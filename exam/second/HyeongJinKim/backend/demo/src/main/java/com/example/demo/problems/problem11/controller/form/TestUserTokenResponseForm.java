package com.example.demo.problems.problem11.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TestUserTokenResponseForm {

    final private UUID userToken;
}
