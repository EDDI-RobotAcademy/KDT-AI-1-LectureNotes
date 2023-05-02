package kr.eddi.demo.lectureClass.vue.vuetify.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/image-test")
public class VuetifyTestController {

    @GetMapping("/return-img")
    public String imgName () {
        log.info("imageName() ");
        return "loz.jpg";
    }
}
