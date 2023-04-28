package com.example.demo.lectureClass.homework.problem.problem4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/gameCharacter")
public class Problem4Controller {
    ArrayList<CharacterInformation> characterInformationList = new ArrayList<>();
    Character character;
    @PostMapping("/characterInformation")
    public void userInfo(@RequestBody CharacterInformation characterInformation){
        log.info("사용자 정보: "+ characterInformation);
        //characterInformationList.add(characterInformation);
        character = new Character(characterInformation);
        log.info("캐릭터상태: " + character);
    }
    @GetMapping("/characterStatus")
    public UserResponseForm response(){
        UserResponseForm userResponseForm=new UserResponseForm(character);
        return userResponseForm;
    }

}
