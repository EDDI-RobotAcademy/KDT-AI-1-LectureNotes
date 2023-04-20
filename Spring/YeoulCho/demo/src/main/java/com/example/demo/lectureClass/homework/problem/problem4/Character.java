package com.example.demo.lectureClass.homework.problem.problem4;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Character {
    CharacterInformation characterInformation;
    private Integer strength;       // 완력
    private Integer intelligent;    // 지능
    private Integer dexterity;      // 재주
    private Integer agility;        // 민첩
    private Integer hp;


    public Character(CharacterInformation characterInformation) {
        this.characterInformation = characterInformation;
        randomStatus();
    }

    public void randomStatus() {
        this.strength = CustomRandom.generateNumber(1, 100);
        this.intelligent = CustomRandom.generateNumber(1, 100);
        this.dexterity = CustomRandom.generateNumber(1, 100);
        this.agility = CustomRandom.generateNumber(1, 100);
        this.hp = CustomRandom.generateNumber(1, 100);

    }

}