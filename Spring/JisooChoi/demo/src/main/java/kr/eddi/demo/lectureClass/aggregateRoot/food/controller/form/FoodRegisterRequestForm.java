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
    // Vue 에서 전달해오는 값들을 Form 형태로 받고 있음

    final private String foodName;

    /*
        enum 같은 경우는 어떤 타입으로 받아와야 할 지, 정확하게 명시해주어야 한다.
    */
    @JsonProperty("category")
    final private CategoryType categoryType; // [카테고리 : 채소, 육류, 토핑, 아이스크림]

    final private Integer foodPrice; // 단위당 가격
    final private Integer foodCalorie; // 단위당 칼로리
    final private Integer max; // 최대 수량
    final private Integer min; // 최소 수량
    final private Integer unit;

    @JsonProperty("measure")
    final private AmountType amountType; // [측정단위: 그램, 카운트]

    /*
        이미지 파일의 이름이 다 같아선 안된다.
    */
    public FoodRegisterRequest toFoodRegisterRequest (MultipartFile imageFile){
        /*
            Vue 에서 데이터 전달이
            forData 와 imageFile 이 별도로 왔다고 보아도 무방하기 때문에
            이를 하나로 모아서 등록하는 객체를 만들어주고 있다.
        */
        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName = randomPrefix + imageFile.getOriginalFilename();

        return new FoodRegisterRequest(
            foodName, categoryType, foodPrice, foodCalorie,
            max, min, unit, amountType, uniqueRandomName);

    }
}
