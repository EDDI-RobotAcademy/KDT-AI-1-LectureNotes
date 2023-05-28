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

    @PostMapping(value = "/uploadImgsWithText", //@PostMapping 어노테이션은 value 속성을 사용하여 요청 경로를 지정합니다
            consumes = {
            //consume 은 @PostMapping 에서 사용되는 옵션 중 하나로, 요청의 미디어 타입을 지정합니다
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    // MULTIPART_FORM_DATA_VALUE 는 Spring Framework 에서 멀티파트 요청을 처리할 때 사용되는 상수
    //APPLICATION_JSON_VALUE"는 Spring Framework 에서 JSON 데이터를 처리할 때 사용되는 상수
    public Boolean fileRegisterRequestHandler(
            @RequestPart(value = "imageFileList") List<MultipartFile> fileList, // VUE 에서 파일리스트 전송
            @RequestPart(value = "fileInfo") FileInfoRequestForm info) { //VUE 에서 이미지경로 요청
        log.info("fileRegisterRequestHander(): " + info);
        //"@RequestPart"는 Spring 에서 멀티파트 요청에서 개별 파트(part)를 처리하는 데 사용되는 어노테이션입니다
        // MultipartFile 은 Spring Framework 에서 멀티파트 요청에서 업로드 된 파일을 처리하기 위한 인터페이스입니다.
        // 멀티파트 요청은 하나 이상의 파일과 함께 일반적인 폼 데이터를 전송할 수 있는 HTTP 요청입니다
        return fileService.register(fileList, info);
    }

    @GetMapping("/giveMeImageList")
    public List<ImagePathResponseForm> imageFileStringListRequestHandler() {
        log.info("imageFileStringListRequestHandler()");
        return fileService.imageList();
    }
}
