package com.example.demo.controller;

import com.example.demo.controller.form.VueRequestTestDataFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {

    @PostMapping("/receive-test")
    public void receiveTest (@RequestBody VueRequestTestDataFrom vueRequestTestDataFrom) {
        log.info("received data: " + vueRequestTestDataFrom);
    }
}
