package kr.eddi.demo.lectureClass.vue.files.service;

import kr.eddi.demo.lectureClass.vue.files.controller.form.FileInfoRequestForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info);
}