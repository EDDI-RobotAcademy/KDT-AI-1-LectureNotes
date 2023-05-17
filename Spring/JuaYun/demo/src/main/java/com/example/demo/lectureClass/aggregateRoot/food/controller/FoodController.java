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
    public void foodRegister(
            @RequestPart(value = "imageFile") MultipartFile imageFile,
            @RequestPart(value = "foodInfo") FoodRegisterRequestForm foodRegisterForm) {
        // imageFile 을 MultipartFile 으로 변환
        // MultipartFile 은 Spring 에서 파일 업로드를 처리하기 위한 인터페이스
        // foodInfo 를 FoodRegisterRequestForm 으로 변환
        // FoodRegisterRequestForm 은 식품 정보를 담고 있음
        log.info("foodRegister()");

        foodService.register(foodRegisterForm.toFoodRegisterRequest(imageFile));
    }
}