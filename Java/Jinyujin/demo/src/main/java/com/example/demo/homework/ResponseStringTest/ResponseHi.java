package com.example.demo.homework.ResponseStringTest;

import com.example.demo.lectureClass.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/response-test")
public class ResponseHi {
    @GetMapping("/response-hi")
    public void helloTest(@RequestBody ResponseHiTest responseHiTest) {
        log.info("안녕" + responseHiTest);
    }
}
