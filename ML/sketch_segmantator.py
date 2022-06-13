from skimage.segmentation import felzenszwalb
import numpy as np


class SketchSegmentator:
    def __init__(self, scale: int = 400, sigma: float = 0.2, min_size: int = 400):
        self.scale = scale
        self.sigma = sigma
        self.min_size = min_size

    def get_image_segments(self, image):
        image_segments = felzenszwalb(np.mean(image, axis=2), scale=self.scale, sigma=self.sigma,
                                      min_size=self.min_size, multichannel=False)
        segments = []
        positions = []
        for segment_id in range(image_segments.max()):
            min_i, min_j, max_i, max_j = self.get_rectang(image_segments == segment_id)
            if min_i == max_i or min_j == max_j: continue
            segments.append(image[min_i:max_i, min_j:max_j, :])
            positions.append([min_i, min_j, max_i, max_j])
        return segments, positions

    @staticmethod
    def get_rectang(mask):
        min_i, min_j, max_i, max_j = None, None, None, None
        for row_idx, mask_row in enumerate(mask):
            for col_idx, mask_element in enumerate(mask_row):
                if min_i is None and mask_element:
                    min_i = row_idx
                if mask_element and (min_j is None or min_j > col_idx):
                    min_j = col_idx
                if mask_element:
                    max_i = row_idx
                if mask_element and (max_j is None or max_j < col_idx):
                    max_j = col_idx
        return min_i, min_j, max_i, max_j
