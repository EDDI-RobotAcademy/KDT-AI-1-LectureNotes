package kr.eddi.demo.fetchType.account.controller.form;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountRoleRequestForm {
    final private String role;
}