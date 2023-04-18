package com.example.demo.controller.lectureClass.vue.controller;

import com.example.demo.controller.lectureClass.vue.controller.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {
// application.properties 파일 뒤를 yaml 로 변경해줬음
    @PostMapping("/receive-test")
    public void receiveTest (@RequestBody VueRequestTestDataForm vueRequestTestDataForm) {
        log.info("received data: " +vueRequestTestDataForm);
    }
}
