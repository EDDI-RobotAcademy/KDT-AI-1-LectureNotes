package com.example.demo.lectureClass.testCode.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@Getter
@RequiredArgsConstructor
public class TestAccountLoginResponseForm {

    // UUID(Universally Unique IDentifier)는 네트워크상에서 고유성을 보장하는 ID를 만들기 위한 표준 규약
    final private UUID userToken;
}