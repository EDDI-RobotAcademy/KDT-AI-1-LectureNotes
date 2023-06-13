package com.example.demo.problem10_14.controller.form;

import com.example.demo.problem10_14.entity.TestBusinessMember;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Getter
@RequiredArgsConstructor
public class TestBusinessRequestForm {
    final private String email;
    final private String password;
    final private long registNumber;

    public TestBusinessMember toTestAccount(){
        return new TestBusinessMember(email, password, registNumber);
    }

}
