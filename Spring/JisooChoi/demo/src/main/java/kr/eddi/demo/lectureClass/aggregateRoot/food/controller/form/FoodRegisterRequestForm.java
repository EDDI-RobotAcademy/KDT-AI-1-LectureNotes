package kr.eddi.demo.lectureClass.aggregateRoot.food.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.service.request.FoodRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class FoodRegisterRequestForm {

    final private String foodName;

    /*
        enum 같은 경우는 어떤 타입으로 받아와야 할 지, 정확하게 명시해주어야 한다.
    */
    @JsonProperty("category")
    final private CategoryType categoryType;

    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;

    @JsonProperty("measure")
    final private AmountType amountType;

    /*
        이미지 파일의 이름이 다 같아선 안된다.
    */
    public FoodRegisterRequest toFoodRegisterRequest (MultipartFile imageFile){
        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName = randomPrefix + imageFile.getOriginalFilename();

        return new FoodRegisterRequest(
            foodName, categoryType, foodPrice, foodCalorie,
            max, min, unit, amountType, uniqueRandomName);

    }
}
