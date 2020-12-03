package com.medway.prescriptionservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface AWSS3Service {
    public String uploadFile(final File file);
}
