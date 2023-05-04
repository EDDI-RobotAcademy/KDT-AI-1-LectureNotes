package kr.eddi.demo.lectureClass.vue.files.controller;

import kr.eddi.demo.lectureClass.vue.files.controller.form.FileInfoRequestForm;
import kr.eddi.demo.lectureClass.vue.files.controller.form.ImagePathResponseForm;
import kr.eddi.demo.lectureClass.vue.files.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file-test")
public class FilesTestController {

    final private FileService fileService;

    @PostMapping(value = "/uploadImgsWithText",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public Boolean fileRegisterRequestHandler (
            /*
                @RequestPart 란?
                application/json + multipart/form-data 를 파라미터로 받아야 할 경우 사용한다.
                즉, JSON, XML 등을 포함하는 복잡한 내용의 Part 와 함께 사용된다.

                fileList 에는 우리가 화면에 불러오는 사진들에 대한 리스트가 있음.
                info 에는 우리가 프론트에서지정했던 price 와 productName 에 대한 값이 들어 있다.

                MultipartFile 인터페이스는 스프링에서 업로드 한 파일을 표현할 때 사용되는 인터페이스이다.
            */
            @RequestPart(value = "imageFileList") List<MultipartFile> fileList,
            @RequestPart(value = "fileInfo") FileInfoRequestForm info)
    {

        log.info("fileRegisterRequestHandler(): " + info);

        return fileService.register(fileList, info);
    }

    @GetMapping("/giveMeImageList")
    public List<ImagePathResponseForm> imageFileStringListRequestHandler () {
        log.info("imageFileStringListRequestHandler()");

        return fileService.imageList();
    }
}
