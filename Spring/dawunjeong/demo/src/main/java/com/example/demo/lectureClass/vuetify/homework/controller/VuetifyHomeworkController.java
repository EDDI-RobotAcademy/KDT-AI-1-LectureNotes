package com.example.demo.lectureClass.vuetify.homework.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vuetify")
public class VuetifyHomeworkController {
    @GetMapping("/img")
    public String getImageName () {

        List<String> imageNameList = new ArrayList<>();
        imageNameList.add("dragonquest.png");
        imageNameList.add("ff7.png");
        imageNameList.add("mario.png");
        imageNameList.add("naruto.png");
        imageNameList.add("zeida.png");

        int selectNum = (int) (Math.random() * 4);

        return imageNameList.get(selectNum);
    }
}
