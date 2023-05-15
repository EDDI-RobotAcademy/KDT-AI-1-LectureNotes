package kr.eddi.demo.lectureClass.aggregateRoot.food.controller;

import kr.eddi.demo.lectureClass.aggregateRoot.food.controller.form.FoodRegisterRequestForm;
import kr.eddi.demo.lectureClass.aggregateRoot.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/food-test")
public class FoodController {

    final private FoodService foodService;

    /*
        아래와 같이 consumes 을 사용하면
        하나의 API 에서 JSon 과 MultipartFile 을 한 번에 전달 받을 수 있으며,

        JSon 과 Multipart 를 post 로 받기 위해서
        consumes 파트에 content type 을 명시해야 한다.

        content type 요청 헤더(=프론트 쪽 말하는 거겠죠 ??)가 consumes 에 지정한
        미디어 타입과 일치할 때만 요청을 매핑해준다.

        (즉, 특이점으로는 API 에서 consumes 할 MediaType 을 지정해주어야 한다는 점)
    */
    @PostMapping(value = "/register",
                 consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
                              MediaType.APPLICATION_JSON_VALUE })
                /*
                    MediaType 은 인터넷에 전달되는 파일 포맷과 포맷 콘텐츠를 위한 식별자이고,
                    HTTP 와 HTML 문서 파일 포맷에 사용된다.

                    즉, 모든 미디어 범위를 포함하는 공용 상수 미디어 유형이다.
                    이를 MIME type, content type 이라고도 부른다.
                */
    public void foodRegister (
            /*
                @RequestBody 는 데이터 형식을 JSON 형태로 전달받기 때문에
                이미지나 동영상의 값을 전달받을 수 없고,

                우리는 현재 Json 과 multipart 를 동시에 받아야 하므로
                @RequestPart 를 사용한다.

                RequestPart 의 값은
                vue 에서 formData 에 지정한 key 값과 동일하게 적어주어야 한다.
            */
            @RequestPart(value = "imageFile") MultipartFile imageFile,
            @RequestPart(value = "foodInfo") FoodRegisterRequestForm foodRegisterForm) {

        log.info("foodRegister()");

        foodService.register(foodRegisterForm.toFoodRegisterRequest(imageFile));
    }
}
