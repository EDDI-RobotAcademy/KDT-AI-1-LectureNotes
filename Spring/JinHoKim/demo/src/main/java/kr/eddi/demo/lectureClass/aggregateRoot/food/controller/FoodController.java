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

    @PostMapping(value = "/register",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
                    //MediaType.MULTIPART_FORM_DATA_VALUE 는 스프링에서 제공하는 MediaType 클래스의 상수입니다.
                    // 이 값은 "multipart/form-data"를 나타내며, 파일 업로드와 관련된 기능을 사용할 때 주로 사용됩니다.
                         MediaType.APPLICATION_JSON_VALUE})
                     //"application/json"을 나타내며, JSON 형식의 데이터를 나타내는 미디어 타입을 지정하는 데 사용됩니다.
    public void foodRegister(
            @RequestPart(value = "imageFile")MultipartFile imageFile,
            @RequestPart(value = "foodInfo") FoodRegisterRequestForm foodRegisterForm) {
        log.info("foodRegister()");

        foodService.register(foodRegisterForm.toFoodRegisterRequest(imageFile));
    }
}
