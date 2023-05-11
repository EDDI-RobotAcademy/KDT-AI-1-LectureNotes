package kr.eddi.demo.lectureClass.jpa.files.controller;

import kr.eddi.demo.lectureClass.jpa.files.controller.form.FileInfoRequestForm;
import kr.eddi.demo.lectureClass.jpa.files.controller.form.ImagePathResponseForm;
import kr.eddi.demo.lectureClass.jpa.files.service.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/file")
public class FilesTestController {

    final private FileServiceImpl fileServiceImpl;

    @PostMapping(value = "/uploadImgsWithText",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public Boolean fileRegisterRequestHandler(
            @RequestPart(value = "imageFileList") List<MultipartFile> fileList,
            @RequestPart(value = "fileInfo") FileInfoRequestForm info){
        log.info("handler"+info);

        return fileServiceImpl.register(fileList, info);
    }

    @GetMapping("/giveMeImageList")
    public List<ImagePathResponseForm> imageFileStringListRequestHandler () {
        log.info("imageFileStringListRequestHandler()");

        return fileServiceImpl.imageList();
    }
}
