package kr.eddi.demo.lectureClass.aggregateRoot.food.service.request;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.Food;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FoodRegistRequest {
    // 식재료, 재료이미지, 재료카테고리, 재료, 측량
    final private String foodName;
    final private CategoryType categoryType;
    final private Integer foodPrice;
    final private Integer calories;
    final private Integer max;
    final private Integer min;
    final private Integer unit;
    final private AmountType amountType;
    final private String uniqueRandomName;

    public Food toFood() {
        return new Food();
    }
}
