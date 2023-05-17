package com.example.demo.lectureClass.aggregateRoot.food.controller.form;

import com.example.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import com.example.demo.lectureClass.aggregateRoot.food.service.request.FoodRegisterRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class FoodRegisterRequestForm {

    final private String foodName;

    @JsonProperty("category")
    final private CategoryType categoryType;

    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;

    @JsonProperty("measure")
    final private AmountType amountType;

    public FoodRegisterRequest toFoodRegisterRequest (MultipartFile imageFile) {
        // 랜덤 고유 ID값을 만듬
        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName = randomPrefix + imageFile.getOriginalFilename();

        //  foodName, categoryType, foodPrice, foodCalorie,
        //                max, min, unit, amountType 정보
        // uniqueRandomName 위에서 만든 이미지
        return new FoodRegisterRequest(
                foodName, categoryType, foodPrice, foodCalorie,
                max, min, unit, amountType, uniqueRandomName);
    }
}