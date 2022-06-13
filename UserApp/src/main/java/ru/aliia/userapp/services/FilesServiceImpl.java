package ru.aliia.userapp.services;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FilesServiceImpl implements FilesService {

    @Value("${files.storage.path}")
    private String storagePath;

    @Override
    public void addFileToResponse(String fileName, HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");
        try {
            IOUtils.copy(new FileInputStream(storagePath + "\\" + fileName), response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
