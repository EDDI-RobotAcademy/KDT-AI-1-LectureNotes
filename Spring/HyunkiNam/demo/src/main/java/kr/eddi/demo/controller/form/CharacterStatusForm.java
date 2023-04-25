package kr.eddi.demo.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterStatusForm {
    final private String user_email;
    final private int strength;
    final private int dexterity;
    final private int intellect;
}
