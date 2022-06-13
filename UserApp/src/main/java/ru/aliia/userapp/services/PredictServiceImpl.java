package ru.aliia.userapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import ru.aliia.userapp.AliiaDiplomaApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class PredictServiceImpl implements PredictService {

    private static final String PREDICT_URL = "/predict_single";

    private static final String POST_PROCESS_URL = "/process";

    private final RestTemplate restTemplate;

    @Value("${ml.service.url}")
    private String mlServiceUrl;

    @Value("${postProcessor.url}")
    private String postProcessorUrl;

    @Value("${files.storage.path}")
    private String storagePath;

    @Override
    public String predict(MultipartFile multipart) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("file", multipart.getResource());

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);

        String jsonResponse = restTemplate.postForEntity(mlServiceUrl + PREDICT_URL, request, String.class)
                .getBody();
        save(multipart);

//        return sendToPostProcessor(jsonResponse);
        return sendToPostProcessor(AliiaDiplomaApplication.fakeProcess(Objects.requireNonNull(multipart.getOriginalFilename())));
    }

    @Override
    public void upload(MultipartFile multipart) {

    }

    @Override
    public void tune(MultipartFile multipart) {

    }

    private String sendToPostProcessor(String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        return restTemplate.postForEntity(postProcessorUrl + POST_PROCESS_URL, request, String.class)
                .getBody();
    }

    private void save(MultipartFile multipart) {
        try {

            Files.copy(multipart.getInputStream(), Paths.get(storagePath, multipart.getOriginalFilename()));

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
