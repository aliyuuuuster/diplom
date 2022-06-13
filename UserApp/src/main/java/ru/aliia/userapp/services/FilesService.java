package ru.aliia.userapp.services;

import javax.servlet.http.HttpServletResponse;

public interface FilesService {
    void addFileToResponse(String fileName, HttpServletResponse response);
}
