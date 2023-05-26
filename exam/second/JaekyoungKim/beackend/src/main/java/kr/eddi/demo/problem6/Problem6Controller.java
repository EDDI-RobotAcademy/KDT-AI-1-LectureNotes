package kr.eddi.demo.problem6;

import kr.eddi.demo.utility.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/give-me")
public class Problem6Controller {
 /*
    SPRING-ROLL-DICE

    SRD-1 랜덤 주사위 전달 합니다.

    SUCCESS-CRITERIA
        1. 랜덤 메서드 활용하여 랜덤 주사위값 만든다.
        2. 주사위값 리턴 한다.
    TO-DO
        1. 뷰와 통신할 컨틀롤러 작성한다.
        2. 겟 매핑으로 경로 지정한다.
        3. 주사위 값 리턴한다.
 */
    @GetMapping("/dice-num")
    public Integer rollDice(){
        final int MAX=6;
        final int MIN=1;

        return CustomRandom.generateNumber(MIN,MAX);

    }
}
