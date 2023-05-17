package com.example.demo.lectureClass.homework.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/hello")
public class AxiosTest {
    @PostMapping("/hi")
    public void ResAxiosTest (@RequestBody Inform inform){
        log.info("dsf" + inform);
    }

}
