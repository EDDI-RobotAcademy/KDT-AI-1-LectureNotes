package kr.eddi.demo.vue.controller;

import kr.eddi.demo.utility.CustomRandom;
import kr.eddi.demo.vue.controller.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {
    /* 실제 @RequestMapping("/vue-test")와 @PostMapping("receive-test")로 URL 경로가 만들어짐
        아래쪽에 있는 @RequestBody를 살펴봐야 합니다.
        객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
        또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송한 양식을 동일하게 유지하고 있어야 합니다.
        전송한 이름에 해당하는 studentName, studentAge 같은 정보가 정확하게 일치해야 합니다.
   */
    int abx=0;
    @PostMapping("/receive-test")
    public void receiveTest (@RequestBody VueRequestTestDataForm vueRequestTestDataForm) {
        log.info("received data: " + vueRequestTestDataForm);
        getNum(vueRequestTestDataForm);


    }
@GetMapping("/get-num")
    public Integer getNum(VueRequestTestDataForm vueRequestTestDataForm) {
        int abx= vueRequestTestDataForm.getNumberA();
        return (Integer)abx;
    }
//    @PostMapping("/num-test")
//    public void receiveTest (@RequestBody NumForm numForm) {
//        log.info("received data: " + numForm);
//    }
//    @GetMapping("/get-num")
//    public Integer getNum(){
//        abx=
//        return (Integer) abx;
//    }

    @GetMapping("/get-random-dice")
    public Integer getRandomDice () {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return (Integer) CustomRandom.generateNumber(MIN, MAX);
    }
    @GetMapping("/get-tempo-password")
    public String getTempoPassword(){
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

        for (int j = 0; j < emailLength; j++) {
            tmpString += (char) CustomRandom.generateNumber('a', 'z');
    }return tmpString;
}
    @GetMapping("/random-dice-game")
    public String getDiceGame(){
        final int MIN = 1;
        final int MAX = 6;
        log.info("getDiceGame() 요청!");
        final int DICE_ONE=CustomRandom.generateNumber(MIN, MAX);
        final int DICE_TWO=CustomRandom.generateNumber(MIN, MAX);
        String judgeString="";
        if((DICE_ONE+DICE_TWO)%2==0){
            judgeString=DICE_ONE+" 더하기 "+DICE_TWO+"는 "+"짝수로 승리";
        }
        if((DICE_ONE+DICE_TWO)%2!=0){
            judgeString=DICE_ONE+" 더하기 "+DICE_TWO+"는 "+"홀수로 패배";
        }
        return judgeString;
    }

    @PostMapping("/dice-num")
    public Integer postDice () {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return (Integer) CustomRandom.generateNumber(MIN, MAX);
    }



}