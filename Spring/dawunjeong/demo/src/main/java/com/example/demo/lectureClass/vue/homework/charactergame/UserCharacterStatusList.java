package com.example.demo.lectureClass.vue.homework.charactergame;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserCharacterStatusList {
    private int currentCharacterId;
    int[] characterStatus;

    public UserCharacterStatusList(int currentCharacterId, int[] characterStatus) {
        this.currentCharacterId = currentCharacterId;
        this.characterStatus = characterStatus;
    }
}
