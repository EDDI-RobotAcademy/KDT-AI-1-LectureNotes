package com.example.demo.lectureClass.homework.bank6;

import com.example.demo.lectureClass.homework.bank6.form.ImageNameForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/image-problem")
public class bank6Controller {

    @PostMapping("/getImageName")
    public String getImageName (@RequestBody ImageNameForm imageNameForm) {
        log.info("received data: " + imageNameForm);
//        String imageName =  new ImageNameForm(imageNameForm.getImageName()).getImageName();
        return new ImageNameForm(imageNameForm.getImageName()).getImageName();
    }
}
