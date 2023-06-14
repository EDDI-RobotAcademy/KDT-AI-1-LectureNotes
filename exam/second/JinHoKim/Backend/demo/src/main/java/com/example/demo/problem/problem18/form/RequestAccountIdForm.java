package com.example.demo.problem.problem18.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {
    private Long accountId;

    public RequestAccountIdForm(Long accountId) {
        this.accountId = accountId;
    }
}