package com.example.demo.lectureClass.vue.uiVuetify.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/give-me")
@RestController
public class UiVuetifyController {

    @GetMapping("/image-path")
    public String giveMeImage() {

        log.info("giveMeImage()");

        return "jjangGu.png";
    }
}
