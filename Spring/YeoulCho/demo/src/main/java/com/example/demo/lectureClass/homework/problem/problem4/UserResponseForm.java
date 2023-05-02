package com.example.demo.lectureClass.homework.problem.problem4;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserResponseForm {
    Character character;

    public UserResponseForm(Character character) {
        this.character = character;
    }
}
