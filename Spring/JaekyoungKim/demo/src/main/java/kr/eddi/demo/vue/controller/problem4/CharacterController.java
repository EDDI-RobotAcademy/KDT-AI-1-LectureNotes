package kr.eddi.demo.vue.controller.problem4;
import kr.eddi.demo.utility.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/game-test")
public class CharacterController {

    @PostMapping("/character")
    public List<StatusForm> makeCharacter(@RequestBody InfoForm infoForm){
        log.info(" 받은 정보 " +infoForm);
        String postId=infoForm.getId();
        final int Min=1;
        final int Max=10;

        List<StatusForm> status=new ArrayList<>();
        final  StatusForm statusForm1= new StatusForm("STR",(Integer) CustomRandom.generateNumber(Min, Max));
        status.add(statusForm1);
        final  StatusForm statusForm2= new StatusForm("DEX",(Integer) CustomRandom.generateNumber(Min, Max));
        status.add(statusForm2);
        final  StatusForm statusForm3= new StatusForm("INT",(Integer) CustomRandom.generateNumber(Min, Max));
        status.add(statusForm3);
        final  StatusForm statusForm4= new StatusForm("LUK",(Integer) CustomRandom.generateNumber(Min, Max));
        status.add(statusForm4);

        return status;
    }


}
