package kr.eddi.demo.lectureClass.vue.problem4.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameCreateCharacterForm {
    private final String userId;
    private final String userPw;

}
