package com.example.demo.lectureClass.homework.problem.problem6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/image")
public class Problem6Controller {
    @CrossOrigin(origins = "http://localhost:8081")
    //No 'Access-Control-Allow-Origin' 오류 발생으로 vue 경로 임시 허용
    @GetMapping("/imageName")
    public String imageResponse(){
        String mario= "마리오.png";
        log.info("imageResponse: "+ mario);

        return mario;
    }
}
