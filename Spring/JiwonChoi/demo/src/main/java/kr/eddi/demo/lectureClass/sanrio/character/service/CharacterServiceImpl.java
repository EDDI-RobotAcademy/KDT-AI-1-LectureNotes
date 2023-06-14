package kr.eddi.demo.lectureClass.sanrio.character.service;

import kr.eddi.demo.lectureClass.sanrio.character.controller.form.CharacterRegisterForm;
import kr.eddi.demo.lectureClass.sanrio.character.entity.Character;
import kr.eddi.demo.lectureClass.sanrio.character.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService{
    final private CharacterRepository characterRepository;


    @Override
    public Character register(CharacterRegisterForm characterRegisterForm) {
        Character character = characterRegisterForm.toCharacter();
        return characterRepository.save(character);
    }
}
