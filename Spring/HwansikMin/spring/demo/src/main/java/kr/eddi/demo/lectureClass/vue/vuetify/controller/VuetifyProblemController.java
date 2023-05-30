package kr.eddi.demo.lectureClass.vue.vuetify.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/give-me")
public class VuetifyProblemController {

    @GetMapping("/image-path")
    public String returnImagePath () {
        log.info("returnImagePath()");

        return "loz.jpg";
    }
}
