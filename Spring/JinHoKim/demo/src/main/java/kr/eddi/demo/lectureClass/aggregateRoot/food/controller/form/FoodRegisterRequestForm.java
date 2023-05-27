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
    // @JsonProperty 는 JSON 데이터와 Java 객체 간의 필드 매핑을 지정하는 것입니다.

    final private Integer foodPrice;
    final private Integer foodCalorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;

    @JsonProperty("measure")
    final private AmountType amountType;

    public FoodRegisterRequest toFoodRegisterRequest(MultipartFile imageFile) {
        // MultipartFile 은 스프링 프레임워크에서 파일 업로드를 처리하기 위해 제공되는 인터페이스입니다.
        // MultipartFile 을 사용하면 클라이언트로부터 전송된 파일 데이터를 서버에서 처리할 수 있습니다.
        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName = randomPrefix + imageFile.getOriginalFilename();

        return new FoodRegisterRequest(
                foodName, categoryType, foodPrice, foodCalorie,
                max, min, unit, amountType, uniqueRandomName);
    }
}
