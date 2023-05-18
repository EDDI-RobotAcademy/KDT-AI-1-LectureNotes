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

    // 식재료, 재료 이미지, 재료 카테고리 + 매개정보, 재료 측량 + 매개정보
    final private String foodName;
    final private CategoryType categoryType;
    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;
    final private AmountType amountType;

    // 이미지 파일의 이름이 다 같아선 안되서 [UUID + 파일 이름] 인 값 ↓
    final private String uniqueRandomName;

    public Food toFood() {
        return new Food(
                foodName,
                FoodImage.of(uniqueRandomName)
                /*
                    Food 객체로 만들기 위해 넘겨지는 값은
                    foodName 과 foodImage 가 되어야 한다.

                    ★ foodName 은 존재하니까 OK !

                    foodImage 는 존재하지 않고 [UUID 값 + 파일 이름] 형태이므로
                    FoodImage 객체로 가공한 뒤, Food 객체를 만들어야 한다.

                    FoodImage.of() 를 통해 FoodImage 객체가 리턴되었다 !
                    ★ foodImage OK !
                */
        );
    }
}
