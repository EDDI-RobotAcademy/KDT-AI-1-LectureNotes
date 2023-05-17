package com.example.demo.problem10_14;

import com.example.demo.problem10_14.entity.Member;
import com.example.demo.problem10_14.form.MemberRegisterRequestForm;
import com.example.demo.problem10_14.service.MemberRegisterRequest;
import com.example.demo.problem10_14.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class Test10Controller {

    final private MemberService memberService;
    @PostMapping("/register")
    public Member registerMember(@RequestBody MemberRegisterRequestForm requestForm){
        log.info(requestForm.getEmail());
        MemberRegisterRequest request= requestForm.toMemberRegisterRequest();

        return memberService.register(request);
    }


}
