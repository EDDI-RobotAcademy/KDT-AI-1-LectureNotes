package kr.eddi.demo.problem1319.Account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class AccountLoginResponseForm {
    final private UUID userToken;
}
