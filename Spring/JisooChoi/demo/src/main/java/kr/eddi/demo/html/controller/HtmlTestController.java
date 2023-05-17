package kr.eddi.demo.html.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// RestController 가 붙어 있으면 데이터를 JSON 이라는 형태로 내보내게 된다.
// Web 상에서 데이터를 주고 받는 형식은 대부분 이 JSON 방식을 사용하게 된다.
// 그러므로 데이터를 주고 받는 상황에서는 전부 RestController를 사용하게 된다.
// 물론 Legacy Project의 경우 Backend와 Frontend가 결합되어 있다.
// 이런 경우엔 Controller를 사용하게 된다.

// 최신 트렌드는 Front쪽과 통신하기 위해 RestController로 Back을 구성한다.

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// slf4j는 log.info()에 정보를 출력하기 위한 목적으로 사용합니다.
// 아래와 같은 메시지가 나옵니다.
// 2023-04-10T11:39:37.387+09:00  INFO 8124 ---
// [nio-8080-exec-1] k.e.demo.controller.HtmlTestController : It is Ok ?
// 나중에 프로젝트 할 때도 어디에서 문제 터졌는지 추적하기 위해 반드시 필요하다.
// 지금 작업이 어디까지 진행되었는지 파악할 수 있기 때문에 중요하다.

// RequestMapping은 Domain을 분리하기 위한 목적으로 사용한다.
// 작업 예로 product/register, board/register 같은 게 있다 가정해보자.
// register만 보면 이게 상품 등록일까? 게시물 등록일까 ? 뭘까? 알 수 없다.
// 앞에 RequestMapping("/product") 같은 것을 설정해서
// 상품에 대한 등록인지,게시물에 대한 등록인지를 명시하기 위한 작업이다.
@Slf4j
@Controller
@RequestMapping("/html-test")
public class HtmlTestController {

    // HTTP 통신 방식에 GET, REST, POST, PUT, DELETE 가 존재한다.
    // 보편적으로 웹 브라우저 주소창에 입력하는 모든 정보는 GET으로 처리된다.
    @GetMapping("/print-time")
    public String printTime (Locale locale, Model model) {
        log.info("Is it Ok ?");

        Date date = new Date();
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        // 날자 형식 생성
        String formattedDate = dateFormat.format(date);
        // serverTime 속성에 만들어진 날자 형식 대입
        model.addAttribute("serverTime", formattedDate); //-> 이게 빠지면 시간 출력이 안 된다.
        // html 코드 printTime.html 호출 (resources/templates/printTime.html)
        return "printTime";
    }
}
