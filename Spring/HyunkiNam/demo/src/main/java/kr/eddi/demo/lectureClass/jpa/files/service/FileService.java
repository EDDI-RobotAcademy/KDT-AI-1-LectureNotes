package kr.eddi.demo.lectureClass.jpa.files.service;

import kr.eddi.demo.lectureClass.jpa.files.controller.form.FileInfoRequestForm;
import kr.eddi.demo.lectureClass.jpa.files.controller.form.ImagePathResponseForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info);

    List<ImagePathResponseForm> imageList();
}
