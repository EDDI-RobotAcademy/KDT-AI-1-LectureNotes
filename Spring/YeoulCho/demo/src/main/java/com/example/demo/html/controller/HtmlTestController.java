package com.example.demo.html.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//Slf4j는 log.info()에 정보를 출력하기 위한 목적으로 사용합니다.
//아래와 같은 메시지가 나옵니다.
//2023-04-10T11:44:06.363+09:00  INFO 3736 ---
// [nio-8080-exec-1] c.e.d.h.controller.HtmlTestController    : hi
//나중에 프로젝트 할 때도 어디에서 문제 터졌는지 추적하기 위해 반드시 필요합니다.
//지금 작업이 어디까지 진행되었는지 파악을 할 수 있기 때문에 중요합니다.

//RequestMapping은 Domain을 분리하기 위한 목적으로 사용합니다.
//작업 예로 product/register, board/register 같은게 있다 가정해봅시다.
//register만 보면 이게 상품등록일까? 게시물등록일까? 뭘까? 알수가 없습니다.
//앞에 RequestMapping("/product") 같은 것을 설정해서
//상품에 대한 등록인지, 게시물에 대한 등록인지를 명시하기 위한 작업입니다.
@Slf4j
@Controller
@RequestMapping("/html-test")

public class HtmlTestController {

    //HTTP 통신 방식에 GET, POST, PUT, DELETE 가 존재합니다.
    //보편적으로 웹 브라우저 주소창에 입력하는 모든 정보는 GET으로 처리됩니다.
    @GetMapping("/print-time")
    public String printTime(Locale local, Model model){
        log.info("hi");

        Date date = new Date();
        DateFormat dataFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local);
        String formattedDate = dataFormat.format(date); //날짜 형식 생성
        //serverTime 속성에 만들어진 날짜 형식 대입
        model.addAttribute("serverTime", formattedDate);
        //htmml 코드 printTime.html 호출(resource/template/printTime.html)
        return "printTime";
    }
}
