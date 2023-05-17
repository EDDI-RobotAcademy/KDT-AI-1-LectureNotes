package com.example.demo.exam.refactorAccount.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class RefactorAccountLoginResponseForm {
    final private UUID userToken;
}
