package com.example.demo.practice.gameCharacter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class CharacterAccountForm {
    final private String email;
    final private String password;
}
