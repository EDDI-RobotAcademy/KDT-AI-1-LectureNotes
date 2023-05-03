package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.entity.DownloadImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/img-request")
public class VueProblem6Controller {

    @PostMapping("/get-path")
    public String getDownloadImagePath () {
        return new DownloadImage().downloadImage();
    }
}
