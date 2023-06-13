package com.example.demo.problem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("hello")
public class problem2 {


    @GetMapping("hi")
    public String request () {


        return request();
    }


}
