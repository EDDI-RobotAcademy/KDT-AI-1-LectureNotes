package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountMultiResponseForm {
    final private Boolean isCurrentInfo;
    final private String userEmailInfo;
    final private Integer userIdInfo;
}