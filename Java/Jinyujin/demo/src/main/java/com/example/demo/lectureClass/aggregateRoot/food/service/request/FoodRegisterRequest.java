package com.example.demo.lectureClass.aggregateRoot.food.service.request;

import com.example.demo.lectureClass.aggregateRoot.food.controller.form.FoodRegisterRequestForm;
import com.example.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.Food;
import com.example.demo.lectureClass.aggregateRoot.food.entity.FoodImage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FoodRegisterRequest {

    final private String foodName;
    final private CategoryType categoryType;
    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;
    final private AmountType amountType;
    final private String uniqueRandomName; // 얘까지 추가!

    // 이제 생각해야 하는 것 = 엔티티!
    // 얘 aggregate가 어떻게 구성될지 생각해야 함
    // 일단 식재료 있을꺼고, 재료 이미지, 카테고리, 재료 측량
    // 이렇게 구성되어 있다고 볼 수 있음
    // 식재료와 재료 카테고리/ 식재료와 재료 측량을 연결할 매개정보가 필요할 것
    // -> entity 6개 필요하겠구나
    // 여기서 가장 중요한 정보: 식재료 food
    // 이렇게 덩어리채로 -> aggregate
    // 지금 이렇게 조각을 낸 이유? 사진을 바꿀 수 있어야함
    // 근데 사진 수정을 하려는데 모든 데이터를 다 바꿔야 하는 경우 - 비용 많이 듬
    // 그래서 필요한 것 단위로 쪼갠 것
    // 이제 엔티티 만들러 가기

    public Food toFood() {
        return new Food(
                foodName,
                FoodImage.of(uniqueRandomName));
    }

    // 서비스에서 request를 따로 만든 이유는?
    // formData로 foodInfo와 이미지 정보를 함께 받아왔지만
    // controller에서 @RequestPart로 따로 받음
    // requestForm에서는 Info에 대한 정보만 있고
    // request에서 String uniqueRandomName으로 이미지에 대한 정보까지 받음
    // 그래서 request만으로 service를 깔끔하게 돌릴 수 있는 것
    // RequestForm이 양식이라면 Request는 실질적인 요청
    // 그리고 service가 이 요청을 처리하는 구조
}
