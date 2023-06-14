package kr.eddi.demo.problem2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class Problem2Controller {
    @GetMapping("/hello")
    public String hello (){
        final String hi="hi";
        return hi;
    }

}
