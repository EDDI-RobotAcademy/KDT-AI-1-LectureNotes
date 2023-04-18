package com.example.demo.lectureClass.homework.basic1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/homework-basic1")
public class HomeworkBasic1Controller {
String test;

    @PostMapping("/receive-hello")
    public void receiveHello (@RequestBody String hello) {
        log.info("received data: " + hello);
        this.test = hello;
    }

    @GetMapping("/get-hello")
    public String getHello () {
        return test;
    }
}
