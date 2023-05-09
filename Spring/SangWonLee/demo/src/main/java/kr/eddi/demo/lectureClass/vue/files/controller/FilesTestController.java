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
// /file-test 경로로 매핑
public class FilesTestController {

    final private FileService fileService; // FileService interface를 사용하여 관련 작업을 처리한다.

    @PostMapping(value = "/uploadImgsWithText",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    // /uploadImgsWithText 경로로 매핑되며, post요청을 처리한다.
    // consumes 속성으로 매핑된 요청이 소비할 수 있는 미디어 유형을 지정 한다.
    // 각각 미디어 유형
    // MULTIPART_FORM_DATA_VALUE : 파일 업로드 같은 이진 데이터 전송에 사용된다.
    // MediaType.APPLICATION_JSON_VALUE : JSON 형식의 데이터 전송에 사용된다.

    public Boolean fileRegisterRequestHandler (@RequestPart(value = "imageFileList") List<MultipartFile> fileList,
                                               @RequestPart(value = "fileInfo") FileInfoRequestForm info)
            // imageFileList 이름의 List와 fileInfo 이름의 FileInfoRequestForm 을 인자로 받는다.
    {
        log.info("fileRegisterRequestHandler(): " + info); // 파일의 정보가 잘 들어가는지 확인
                                                        // fileRegisterRequestHandler(): FileInfoRequestForm(price=50000, productName=testProduct)
        return fileService.register(fileList, info);
        // fileList와 info를 인자로 fileService 객체의 register 메소드를 호출.
    }


    @GetMapping("/giveMeImageList")
    // @GetMapping(value = "/giveMeImageList") 원래 이거임 value 값은 생략 가능
    public List<ImagePathResponseForm> imageFileStringListRequestHandler () {
        log.info("imageFileStringListRequestHandler()");

        return fileService.imageList();
    }
}