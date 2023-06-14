package kr.eddi.demo.lectureClass.sanrio.character.controller.form;

import kr.eddi.demo.lectureClass.sanrio.character.entity.Character;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class CharacterRegisterForm {
    final private String name;
    final private Integer number;
    final private String imagePath;

    public Character toCharacter() {
        return new Character(name, number, imagePath);
    }
}
