package kr.eddi.demo.lectureClass.fetchType.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountResponseForm {
    final private Long accountId;
    final private String email;
}
