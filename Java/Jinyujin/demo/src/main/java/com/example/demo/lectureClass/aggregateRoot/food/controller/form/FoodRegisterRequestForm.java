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

    // 아까 만든 foodName 맵핑
    // UI 보면서 만들어놓은 것들 맵핑하기
    final private String foodName;

    // 카테고리는 무수히 많은 종류가 올 수 있음
    // 이럴 때 써먹기 좋은 것이 enum
    @JsonProperty("category")
    final private CategoryType categoryType;
    // 카테고리를 받을 때 문자열로 올지 숫자열로 올지를 명확하게 표기해주어야 함
    // 전달받은 category를 카테고리 타입으로 맵핑할 것

    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;

    // 측정단위가 뭐냐에 따라 달라지는 옵션이 있을 수 있음
    // 얘도 enum으로
    // 여기에는 GRAM이랑 COUNT 들어간다고 설정해뒀음
    @JsonProperty("measure")
    final private AmountType amountType;
    // 전달받은 measure을 amountType으로 맵핑할 것

    // 이미지 파일 만든다고 할 때 이미지 파일 이름이 다 같으면 안됨
    // 여기서 이미지 파일 받을 것
    // 이미지는 뷰에서 files로 보냄
    public FoodRegisterRequest toFoodRegisterRequest (MultipartFile imageFile) {
        UUID randomPrefix = UUID.randomUUID();
        // 사진한테 고유 값 주기 위함
        String uniqueRandomName= randomPrefix + imageFile.getOriginalFilename();

        return new FoodRegisterRequest(
                foodName, categoryType, foodPrice, foodCalorie,
                max, min, unit, amountType, uniqueRandomName);
    }

    // 얘는 controller에서 사용
    // 이 foodRegisterRequestForm 형태로 등록하도록 함
    // 총체적으로 controller에서 등록하는 형식은 여기 form 형식

}
