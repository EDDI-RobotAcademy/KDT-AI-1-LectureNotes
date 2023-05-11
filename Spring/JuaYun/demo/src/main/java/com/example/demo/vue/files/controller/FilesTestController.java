package com.example.demo.vue.files.controller;

import com.example.demo.vue.files.controller.form.FileInfoRequestForm;
import com.example.demo.vue.files.controller.form.ImagePathResponseForm;
import com.example.demo.vue.files.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor // 이게 있어야 final 이 설정됨
@RequestMapping("/file-test")
public class FilesTestController {

    // 실질적으로 여기서 처리해야하는 것은?
    // 이미지는 사이즈가 큼 그래서 db에 저장하면 처리비용이 큼
    // 그래서 사진은 db에 저장하지 않고 사용자 이름과 경로만 가지면 됨
    // 사진자체는 vue 에 넣을거임

    final private FileService fileService;

    @PostMapping(value = "/uploadImgsWithText",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,    // 이미지
                        MediaType.APPLICATION_JSON_VALUE})      // 정보
    public Boolean fileRegisterRequestHandler (@RequestPart(value = "imageFileList") List<MultipartFile> fileList, // 이미지
                                               // vue 에서 전송된 payload 를 위의 @RequestPart 에서 받음
                                               @RequestPart(value = "fileInfo")FileInfoRequestForm info)           // 정보
    {
        log.info("fileRegisterRequestHandler(): " + info);

        return fileService.register(fileList, info);  // 이미지, 정보를 반환

    }

    // 뷰처리 끝내고 겟맵핑
    // 리스트로 이미지패스리스폰스폼을 넘김
    @GetMapping("/giveMeImageList")
    public List<ImagePathResponseForm> imageFileStringListRequestHandler () {
        log.info("imageFileStringListRequestHandler()");

        return fileService.imageList();
    }
}
