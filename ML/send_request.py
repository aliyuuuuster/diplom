import requests

url = 'http://0.0.0.0:8889/predict_single'
files = {'file': open('data/test_images/image_0.jpg', 'rb')}
resp = requests.post(url, files=files)
print(resp.text)
