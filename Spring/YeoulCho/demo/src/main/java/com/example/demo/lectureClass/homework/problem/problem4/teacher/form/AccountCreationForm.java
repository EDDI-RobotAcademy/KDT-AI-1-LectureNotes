package com.example.demo.lectureClass.homework.problem.problem4.teacher.form;

import com.example.demo.lectureClass.homework.problem.problem4.teacher.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm {
    final private String userEmail; //vue에서 post해온 정보가 할당)
    final private String userPassword;

    public Account toAccount(long accountId){
        return new Account(accountId, userEmail, userPassword);
    } //accountId를 통해서 email하고 password는 갖고 있은채로
    // 새로운 Account를 만들어 주겠다.
}
