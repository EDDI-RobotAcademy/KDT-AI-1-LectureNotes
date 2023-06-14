package com.example.demo.vueTest.test02.controller;

import com.example.demo.vueTest.test02.controller.form.VueRequestTestFrom02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
//2. Spring을 이용해서 http://localhost:7777/hello 에 GET 요청을 보내면 "hi" 응답을 리턴하도록 만들어봅시다.
@Slf4j
@RestController
@RequestMapping("")
public class VueTestController02 {
    @PostMapping("/hello")
    public void receiveTest (@RequestBody VueRequestTestFrom02 vueRequestTestFrom02){
        log.info("답변: " + vueRequestTestFrom02);
    }
}
