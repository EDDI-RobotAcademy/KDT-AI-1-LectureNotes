package kr.eddi.demo.lectureClass.vue.problem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Account {

    private int accountId;
    private String newEmail;
    private String newPw;
}