package kr.eddi.demo.lectureClass.testCode.time.controller;

import kr.eddi.demo.lectureClass.testCode.time.entity.TimeTest;
import kr.eddi.demo.lectureClass.testCode.time.repository.TimeTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/time-test")
public class TimeTestController {

    final private TimeTestRepository timeRepository;

    @GetMapping("/check")
    public void checkTime () {
        TimeTest time = new TimeTest();
        time = timeRepository.save(time);

        log.info(String.valueOf(time));
        log.info(String.valueOf(time.getCreatedTime()));

        LocalDateTime currentTime = time.getCreatedTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);

        log.info(formattedDateTime);
    }
}
