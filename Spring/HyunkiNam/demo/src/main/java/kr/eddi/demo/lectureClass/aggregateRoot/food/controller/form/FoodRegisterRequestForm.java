package kr.eddi.demo.lectureClass.aggregateRoot.food.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.service.request.FoodRegisterRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class FoodRegisterRequestForm {

    private String foodName;

    

    @JsonProperty("category")
    private CategoryType categoryType;

    private Integer foodPrice;
    private Integer foodCalorie;
    private Integer max;
    private Integer min;
    private Integer unit;

    @JsonProperty("measure")
    private AmountType amountType;

    public FoodRegisterRequest toFoodRegisterRequest (MultipartFile imageFile) {
        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName = randomPrefix + imageFile.getOriginalFilename();

        return new FoodRegisterRequest(
                foodName, categoryType, foodPrice, foodCalorie,
                max, min, unit, amountType, uniqueRandomName);
    }
}