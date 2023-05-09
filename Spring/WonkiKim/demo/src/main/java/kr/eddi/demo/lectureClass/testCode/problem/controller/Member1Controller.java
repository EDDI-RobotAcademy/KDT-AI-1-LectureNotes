package kr.eddi.demo.lectureClass.testCode.problem.controller;

import kr.eddi.demo.lectureClass.testCode.problem.controller.form.Member1RequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.entity.Member1;
import kr.eddi.demo.lectureClass.testCode.problem.service.Member1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem-member")
public class Member1Controller {
    final private Member1Service memberService;
    @PostMapping("/register")
    public Member1 registerMember (@RequestBody Member1RequestForm memberRequestForm) {
        log.info("registerMember()");

        return memberService.register(memberRequestForm.toMember());
    }
}
