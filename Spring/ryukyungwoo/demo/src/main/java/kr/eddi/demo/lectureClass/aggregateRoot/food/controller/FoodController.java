package kr.eddi.demo.lectureClass.aggregateRoot.food.controller;

import kr.eddi.demo.lectureClass.aggregateRoot.food.controller.form.FoodRegisterRequestForm;
import kr.eddi.demo.lectureClass.aggregateRoot.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j // 이 클래스에서 로깅 기능 (로거)을 활용하기 위해 Lombok의 Slf4j 어노테이션을 사용합니다.
@RestController // 이 클래스가 스프링 RESTful 웹 서비스 컨트롤러임을 명시합니다. 이 클래스는 HTTP 요청을 처리할 메소드들을 포함합니다.
@RequiredArgsConstructor // Lombok이 final 혹은 @NonNull이 붙은 필드를 파라미터로 가진 생성자를 자동으로 생성해줍니다.
@RequestMapping("/food-test") // 이 컨트롤러에서 처리하는 모든 요청에 대한 기본 경로를 "/food-test"로 지정합니다.
public class FoodController {

    final private FoodService foodService; // FoodService의 빈(Bean) 인스턴스를 주입합니다. 이 서비스는 음식 관련 비즈니스 로직을 처리합니다.

    @PostMapping(value = "/register",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }) // "/food-test/register" 경로로 오는 POST 요청을 처리하는 메소드임을 명시합니다. 두 개의 MediaType(MULTIPART_FORM_DATA, APPLICATION_JSON)을 처리합니다.
    public void foodRegister (
            @RequestPart(value = "imageFile") MultipartFile imageFile, // 요청에서 "imageFile" 항목을 받아 MultipartFile 형태로 처리합니다.
            @RequestPart(value = "foodInfo") FoodRegisterRequestForm foodRegisterForm) { // 요청에서 "foodInfo" 항목을 받아 FoodRegisterRequestForm 형태로 처리합니다.

        log.info("foodRegister()"); // foodRegister() 메소드가 호출되었음을 로그로 출력합니다.

        foodService.register(foodRegisterForm.toFoodRegisterRequest(imageFile)); // foodService의 register 메소드를 호출하고, foodRegisterForm에서 FoodRegisterRequest를 생성하여 전달합니다.
    }
}

