package com.example.demo.test.q10_14.member.controller;

import com.example.demo.test.q10_14.member.controller.form.MemberForm;
import com.example.demo.test.q10_14.member.entity.Member;
import com.example.demo.test.q10_14.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class MemberController {
    final private MemberService memberService;

    @PostMapping("/memberRegister")
    public Member registerMember (@RequestBody MemberForm memberForm) {

        return memberService.register(memberForm);
    }
}
