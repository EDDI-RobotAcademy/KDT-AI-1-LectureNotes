package com.example.demo.lectureClass.vuetify.homework.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vuetify")
public class VuetifyHomeworkController {
    @GetMapping("/img")
    public String getImageName () {
        return "naruto.png";
    }
}
