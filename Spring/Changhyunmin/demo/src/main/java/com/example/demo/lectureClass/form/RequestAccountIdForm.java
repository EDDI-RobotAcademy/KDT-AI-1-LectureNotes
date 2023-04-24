package com.example.demo.lectureClass.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {

    private Long gameAccountId;

    public RequestAccountIdForm(Long gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}
