import os
import uvicorn
from fastapi import FastAPI,  File, UploadFile
from PIL import Image
import io
import numpy as np
from sketch_parser import SketchParser

app = FastAPI()
sketch_parser = SketchParser('models/resnet152/')


@app.post("/predict_single")
async def predict_single(file: UploadFile = File(...)):
    contents = await file.read()
    img = Image.open(io.BytesIO(contents))
    img = np.array(img)
    print(img.shape)
    parsed_sketch = sketch_parser.parse_sketch(img)
    return {"message": parsed_sketch}


@app.post("/upload_image")
async def upload_image(label, file: UploadFile = File(...)):
    contents = await file.read()
    img = Image.open(io.BytesIO(contents))
    folder_to_save_image = os.path.join("data",label)
    if not os.path.exists(folder_to_save_image):
        os.mkdir(folder_to_save_image)
    image_idx = len(os.listdir(folder_to_save_image))
    path_to_save_image = os.path.join(folder_to_save_image, f"image_{image_idx}.jpg")
    img.save(path_to_save_image, 'jpg')


@app.post("/finetune")
def finetune():
    return {"message": "NotImplemented Yet"}


if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8889)
