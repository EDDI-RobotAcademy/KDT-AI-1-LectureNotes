package com.example.demo.lectureClass.homework.problem.problem5.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {
    private long gameAccountId;

    public RequestAccountIdForm(long gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}
