package com.example.demo.login;

import com.example.demo.problem10_14.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test20")
public class Test20Controller {

    final private MemberService memberService;
    @PostMapping("/login")
    public LoginResponseForm Login(@RequestBody LoginForm loginForm) {
        LoginResponseForm loginform = memberService.login(loginForm);

        return loginform;
    }
}
