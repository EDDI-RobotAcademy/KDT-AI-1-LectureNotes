package kr.eddi.demo.lectureClass.sanrio.character.service;

import kr.eddi.demo.lectureClass.sanrio.character.controller.form.CharacterRegisterForm;
import kr.eddi.demo.lectureClass.sanrio.character.entity.Character;

public interface CharacterService {
    Character register(CharacterRegisterForm characterRegisterForm);
}
