package com.example.demo.lectureClass.aggregateRoot.food.controller;

import com.example.demo.lectureClass.aggregateRoot.food.controller.form.FoodRegisterRequestForm;
import com.example.demo.lectureClass.aggregateRoot.food.service.FoodService;
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
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
                            MediaType.APPLICATION_JSON_VALUE})
    public void foodRegister (
            @RequestPart(value = "imageFile") MultipartFile imageFile,
            // 이미지는 MultipartFile로 받고
            @RequestPart(value = "foodInfo") FoodRegisterRequestForm foodRegisterRequestForm) {
            // foodInfo는 requestForm으로 받음
            // -> requestForm에는 이미지에 대한 정보는 받지 않는 상태
            // request에서 따로 이미지까지 받고(String으로)
            // 그것을 requestForm 클래스에서 to~메서드를 만들어서
            // 객체로 한꺼번에 반환하여 이미지까지 등록할 수 있도록 함

        log.info("foodRegister()");
        // enum을 사용해서 얘가 궁극적으로 뭘 표현하려는지 아는게 좋음

        foodService.register(foodRegisterRequestForm.toFoodRegisterRequest(imageFile));
    }
}
