package com.example.demo.problem17.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@RequiredArgsConstructor
@Getter
public class AccountLoginResponseForm {

    final private UUID userToken;
}
