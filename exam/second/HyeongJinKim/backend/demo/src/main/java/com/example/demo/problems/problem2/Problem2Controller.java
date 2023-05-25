package com.example.demo.problems.problem2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class Problem2Controller {
    @GetMapping
    public String returnHello () {
        return "hi";
    }
}
