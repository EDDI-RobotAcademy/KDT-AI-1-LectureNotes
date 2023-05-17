package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.InputIdPassword;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.MyCreatedNewCharacter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character-create-test")
public class MyVueProble4Controller {
    List<MyCreatedNewCharacter> myCreatedNewCharaterList = new ArrayList<>();

    @PostMapping("/create-new-character")
    public MyCreatedNewCharacter createdNewCharacterStatusList(@RequestBody InputIdPassword inputIdPassword) {
        log.info("createdNewCharacterStatusList()" + inputIdPassword);

        myCreatedNewCharaterList.add(new MyCreatedNewCharacter(inputIdPassword.getEmail(), inputIdPassword.getPassword()));
        log.info("myCreatedNewCharaterList.get(0)" + myCreatedNewCharaterList.get(0));

        return myCreatedNewCharaterList.get(0);
    }
}
