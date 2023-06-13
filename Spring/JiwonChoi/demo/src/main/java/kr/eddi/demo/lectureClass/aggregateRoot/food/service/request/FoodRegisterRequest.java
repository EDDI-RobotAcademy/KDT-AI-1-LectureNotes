package kr.eddi.demo.lectureClass.aggregateRoot.food.service.request;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.Food;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.FoodImage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FoodRegisterRequest {

    // 식재료, 재료 이미지, 재료 카테고리 + 매개 정보, 재료 측량 + 매개 정보
    final private String foodName;
    final private CategoryType categoryType;
    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;
    final private AmountType amountType;
    final private String uniqueRandomName;


    public Food toFood() {
        return new Food(
                foodName,
                FoodImage.of(uniqueRandomName));
    }
}
