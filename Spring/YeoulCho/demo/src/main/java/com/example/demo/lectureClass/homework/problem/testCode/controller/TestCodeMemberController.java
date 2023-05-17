package com.example.demo.lectureClass.homework.problem.testCode.controller;

import com.example.demo.lectureClass.homework.problem.testCode.Service.TestMemberService;
import com.example.demo.lectureClass.homework.problem.testCode.entity.TestMember;
import com.example.demo.lectureClass.homework.problem.testCode.form.MemberRequestForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/accountMember")
public class TestCodeMemberController {
    private TestMemberService testMemberService;

    @PostMapping("/resisterMember")
    public boolean createMember(@RequestBody MemberRequestForm memberRequestForm){
        final TestMember testMember= memberRequestForm.toTestMember();
        testMemberService.register(testMember);
        return true;
    }
}
