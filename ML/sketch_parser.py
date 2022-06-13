from sketch_classifier import SketchClassifier
from sketch_segmantator import SketchSegmentator
from PIL import Image


class SketchParser:
    def __init__(self, model_path):
        self.sketch_classifier = SketchClassifier(model_path)
        self.sketch_segmentator = SketchSegmentator()

    def parse_sketch(self, image):
        image_segments, positions = self.sketch_segmentator.get_image_segments(image)
        labels = []
        for image_segment in image_segments:
            #print(image_segment.shape)
            image_segment = Image.fromarray(image_segment)
            #print(image_segment.size)
            labels.append(self.sketch_classifier.predict(image_segment))
        return [{'positions': position, 'label': label} for position, label in zip(positions, labels)]
