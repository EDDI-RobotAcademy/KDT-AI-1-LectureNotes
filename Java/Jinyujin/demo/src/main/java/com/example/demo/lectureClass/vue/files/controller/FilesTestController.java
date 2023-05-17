package com.example.demo.lectureClass.vue.files.controller;

import com.example.demo.lectureClass.vue.files.controller.form.FileInfoRequestForm;
import com.example.demo.lectureClass.vue.files.controller.form.ImagePathResponseForm;
import com.example.demo.lectureClass.vue.files.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file-test")
@RequiredArgsConstructor
public class FilesTestController {

    final private FileService fileService;

    // 파일이라서 포스트맵핑 주소가 달라짐
    @PostMapping(value = "/uploadImgsWithText",
            // 아래 애들은 다 내장되어 있는 속성들
            consumes = {
            // consumes는 들어오는 데이터 타입을 정의할 때 사용
            // 즉 클라이언트가 서버에 보내는 데이터 타입을 명시
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    // 이미지 타입 명시
                    // 하나 이상의 파일과 함께 전송할 때 사용 -> 처리하는 데에는 MultipartFile 객체 사용
                    // 파일 업로드를 위한 미디어 타입
                    MediaType.APPLICATION_JSON_VALUE })
                    // 상품 정보 타입 명시 - JSON으로 바꿔주어야 하는 것
                    // JSON 데이터가 요청 본문에 담겨있음을 나타냄
                    // 둘이 함께 사용하면 클라이언트에서 파일 업로드와 함께 JSON 데이터를 요청 본문에 담아서 전송할 수 있으며,
                    // 해당 컨트롤러에서 이를 받아들일 수 있음

    public Boolean fileRegisterRequestHandler (
            @RequestPart(value = "imageFileList") List<MultipartFile> fileList,
            // 이미지
            @RequestPart(value = "fileInfo") FileInfoRequestForm info) {
            // 상품 정보
            // RequestPart라는 것 사용하게 됨
            // 사진 파일과 파일 정보를 하나씩 받아와야 함

        log.info("fileRegisterRequestHandler(): " + info);

        return fileService.register(fileList, info);
    }
//    스프링으로 받은 이미지, 텍스트 데이터를 이제 DB에 저장해야 하는데
//    이미지는 크기가 크기 때문에 비용이 많이 들음
//    실질적으로 DB라는 애는 경로만 가지고 있으면 됨
    // 파일 자체는 vue에 넣어줄 것임
    // JPA 환경 구축해야함

    @GetMapping("/giveMeImageList")
    public List<ImagePathResponseForm> imageFileStringListRequestHandler () {
        log.info("imageFileStringListRequestHandler()");

        return fileService.imageList();
    }
    // 겟맵핑은 리스트 스트링을 넘기면 될 것 우리는 경로만 저장하고 있으니까
}
