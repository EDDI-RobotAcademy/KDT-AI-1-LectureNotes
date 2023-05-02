package com.example.demo.lectureClass.vue.prob4.contr;

import com.example.demo.lectureClass.vue.prob4.contr.form.AccoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/game-test")
public class prob4Contr {

    @PostMapping("/account")
    public Boolean createAcc (@RequestBody AccoForm accoForm){
        // 데이터 잘 가지고 왔는지 확인하려면 log를 찍어본다.
        log.info("ok: " + accoForm);

        return null;
    }
}
