package kr.eddi.demo.lectureClass.vue.controller.form;

import kr.eddi.demo.lectureClass.diceRule.player.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountMultiResponseForm {
    final private Boolean isCurrentInfo;
    final private String userEmailInfo;
    final private Integer userIdInfo;
}