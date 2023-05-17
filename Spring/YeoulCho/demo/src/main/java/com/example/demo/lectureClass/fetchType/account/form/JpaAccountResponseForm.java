package com.example.demo.lectureClass.fetchType.account.form;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountResponseForm {
    final private Long accountId;
    final private String email;
}
