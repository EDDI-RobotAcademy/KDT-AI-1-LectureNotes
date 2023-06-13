package com.example.demo.problem.problem2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/hello")
public class Problem2Controller {

    @GetMapping("/problem2")
    public String SecondProblem() {
        return "Hi";
    }
}
