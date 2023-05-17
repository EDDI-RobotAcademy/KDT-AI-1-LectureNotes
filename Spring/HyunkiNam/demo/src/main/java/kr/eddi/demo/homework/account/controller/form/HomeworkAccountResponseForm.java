package kr.eddi.demo.homework.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HomeworkAccountResponseForm {
    final private Long accountId;
    final private String email;
}