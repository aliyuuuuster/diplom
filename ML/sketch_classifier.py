import torch
from torchvision import datasets, transforms, models
from fastai.vision.all import *
import json
import os


class SketchClassifier:
    def __init__(self, model_folder):
        model_path = os.path.join(model_folder, 'model.pth')
        class_to_idx_fpath = os.path.join(model_folder, 'cls2idx.json')
        self.transforms = transforms.Compose([transforms.CenterCrop(224),
                                              Normalize.from_stats(*imagenet_stats),
                                              transforms.ToTensor(),
                                              ])
        self.model = torch.load(model_path)
        self.name2idx, self.idx2name = self.load_class_to_idx(class_to_idx_fpath)

    def predict(self, image):
        input = self.transforms(image)
        input = input[:3, :, :]
        input = torch.unsqueeze(input, dim=0)
        input = input.to('cuda')
        logps = self.model.forward(input)
        ps = torch.exp(logps)
        top_p, top_class = ps.topk(1, dim=1)
        cls_id = top_class.cpu().numpy()[0][0]
        return self.idx2name[cls_id]

    def load_class_to_idx(self, class_to_idx_fpath):

        with open(class_to_idx_fpath) as input_stream:
            class_to_idx = json.loads(input_stream.read())
        idx_to_classes = {idx: class_name for class_name, idx in class_to_idx.items()}
        return class_to_idx, idx_to_classes
