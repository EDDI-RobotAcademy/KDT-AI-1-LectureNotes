package kr.eddi.demo.lectureClass.sanrio.character.controller;

import kr.eddi.demo.lectureClass.sanrio.character.controller.form.CharacterRegisterForm;
import kr.eddi.demo.lectureClass.sanrio.character.entity.Character;
import kr.eddi.demo.lectureClass.sanrio.character.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sanrio")
public class CharacterController {
    final private CharacterService characterService;

    @PostMapping("/register")
    public Character registerCharacter(@RequestBody CharacterRegisterForm characterRegisterForm) {
        characterService.register(characterRegisterForm);
        log.info("registerCharacter()");
        return null;
    }
}
