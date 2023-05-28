package kr.eddi.demo.lectureClass.vue.vuetify.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//Slf4jSLF4J는 로깅 Facade(퍼사드)이다. 로깅에 대한 추상 레이어를 제공하는 interface 의 모음이다.
//여러 로깅 라이브러리를 하나의 통일된 방식으로 사용할 수 있는 방법을 제공한다.

@RestController
//컨트롤러 @Controller + @ResponseBody가 합쳐진 형태로 JSON 형태의 객체 데이터를 반환합니다.

@RequestMapping("/give-me")
//@RequestMapping("/특정 URL") : Spring 개발 시 특정 URL 로 요청(Request)을 보내면 Controller 에서 어떠한 방식으로 처리할지 정의합니다.

public class VuetifyProblemController {

    //@GetMapping : HTTP Get Method 에 해당하는 단축 표현으로 서버의 리소스를 조회할 때 사용합니다.
    @GetMapping("/image-path")

    public String returnImagePath() {

        log.info("returnImagePath()");
        // FF7.jpg 을 돌려준다.
        return "FF7.jpg";
    }
}
