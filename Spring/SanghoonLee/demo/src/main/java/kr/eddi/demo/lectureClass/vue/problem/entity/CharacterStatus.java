package kr.eddi.demo.lectureClass.vue.problem.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CharacterStatus {

    private int strength;
    private int dexterity;
    private int vital;
    private int intelligence;

    private int whosAccountId;
}
