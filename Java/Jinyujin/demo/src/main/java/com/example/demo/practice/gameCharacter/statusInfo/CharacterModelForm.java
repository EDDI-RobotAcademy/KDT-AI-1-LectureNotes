package com.example.demo.practice.gameCharacter.statusInfo;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CharacterModelForm {

    final static int START = 10;
    final static int END = 20;
    final static int HP_MIN = 70;
    final static int HP_MAX = 150;

    private Integer strength;       // 완력
    private Integer intelligent;    // 지능
    private Integer dexterity;      // 재주
    private Integer agility;        // 민첩
    private Integer hp;            // hp

    private Long whosAccountId; // 상태에서 누구의 아이디인지에 관한 변수 추가해줌
    // 얘들을 생성자 안에 넣어줄 것
    // 그러므로 @RequiredArgsConstructor는 없애주어야 함

    public CharacterModelForm(Long whosAccountId) {
        this.strength = CustomRandom.generateNumber(START, END);
        this.intelligent = CustomRandom.generateNumber(START, END);
        this.dexterity = CustomRandom.generateNumber(START, END);
        this.agility = CustomRandom.generateNumber(START, END);
        this.hp = CustomRandom.generateNumber(HP_MIN, HP_MAX);

        this.whosAccountId = whosAccountId;
    }
}
