package com.example.demo.practice.gameCharacter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/lets-show")
public class MakeGameAccount {

    @PostMapping("/character")
    public CharacterAccountForm MakeGameAccount(@RequestBody CharacterAccountForm characterAccount) {
        // 이메일과 비밀번호를 받아와서 캐릭터 계정 생성
        log.info("accountInfo: " + characterAccount);

        return characterAccount;
    }

    @PostMapping("/character-status")
    @ResponseBody
    public CharactetModelForm showCharacterStatus(CharactetModelForm charactetModelForm) {
        // 게임캐릭터 status 정보 넘기기
        log.info("Charactet status: " + charactetModelForm);

        return charactetModelForm;
    }
}
