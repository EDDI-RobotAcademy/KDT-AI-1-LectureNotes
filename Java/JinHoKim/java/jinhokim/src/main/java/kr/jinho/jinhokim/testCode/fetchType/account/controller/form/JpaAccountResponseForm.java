package kr.jinho.jinhokim.testCode.fetchType.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountResponseForm {
    final private Long accountId;
    final private String email;
}
