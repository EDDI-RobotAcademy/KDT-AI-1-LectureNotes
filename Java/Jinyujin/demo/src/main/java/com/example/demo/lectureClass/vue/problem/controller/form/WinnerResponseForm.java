package com.example.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class WinnerResponseForm {
    private final Integer winnerScore;
    private final String result;
}
