package com.example.demo.evaluation.problem10_14_17_20.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class AccountLoginResponseForm {
    final private UUID userToken;
}
