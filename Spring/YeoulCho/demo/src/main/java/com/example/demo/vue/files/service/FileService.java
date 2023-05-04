package com.example.demo.vue.files.service;

import com.example.demo.vue.files.controller.form.FileInfoRequestForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info);
}
