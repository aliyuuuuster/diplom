package ru.aliia.userapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface PredictService {
    String predict(MultipartFile multipart);

    void upload(MultipartFile multipart);

    void tune(MultipartFile multipart);
}
