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
        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName = randomPrefix + imageFile.getOriginalFilename();

        return new FoodRegisterRequest(
                foodName, categoryType, foodPrice, foodCalorie,
                max, min, unit, amountType, uniqueRandomName);
    }
}
