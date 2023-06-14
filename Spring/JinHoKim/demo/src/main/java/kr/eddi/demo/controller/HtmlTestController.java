package kr.eddi.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// Slf4j는 log.info()에 정보를 출력하기 위한 목적으로 사용합니다.
// 아래와 같은 메시지가 나옵니다.
// 2023-04-10T11:36:04.294+09:00  INFO 13520 ---
// [nio-8080-exec-4] k.e.demo.controller.HtmlTestController   : Is it Ok ?
// 나중에 프로젝트 할 때도 어디에서 문제 터졌는지 추적하기 위해 반드시 필요합니다.
// 지금 작업이 어디까지 진행되었는지 파악을 할 수 있기 때문에 중요합니다.

// RequestMapping은 Domain을 분리하기 위한 목적으로 사용합니다.
// 작업 예로 product/register, board/register 같은게 있다 가정해봅시다.
// register만 보면 이게 상품 등록일까 ? 게시물 등록일까 ? 뭘까 ? 알 수가 없습니다.
// 앞에 RequestMapping("/product") 같은 것을 설정해서
// 상품에 대한 등록인지, 게시물에 대한 등록인지를 명시하기 위한 작업입니다.
@Slf4j
@Controller
@RequestMapping("/html-test")
public class HtmlTestController {

    // HTTP 통신 방식에 GET, POST, PUT, DELETE 가 존재합니다.
    // 보편적으로 웹 브라우저 주소창에 입력하는 모든 정보는 GET으로 처리됩니다.
    @GetMapping("/print-time")
    public String printTime (Locale locale, Model model) {
        log.info("Is it Ok ?");

        Date date = new Date();
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        // 날자 형식 생성
        String formattedDate = dateFormat.format(date);
        // serverTime 속성에 만들어진 날자 형식 대입
        model.addAttribute("serverTime", formattedDate);
        // html 코드 printTime.html 호출 (resources/templates/printTime.html)
        return "printTime";
    }
}
