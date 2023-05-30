package kr.eddi.demo.lectureClass;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TmpController {

    @GetMapping("/integer-request")
    public Integer integerRequest () {
        log.info("integer request");

        return CustomRandom.generateNumber(5, 20);
    }
}
