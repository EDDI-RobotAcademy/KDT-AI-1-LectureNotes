package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.springMemberProblem.Member;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.springMemberProblem.SignUpRequestForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("spring-member-problem")
public class SpringMemberProblemController {
    Map<Integer, Member> memberMap = new HashMap<>();
    @PostMapping("sign-up")
    public int signUpMember(@RequestBody SignUpRequestForm signUpRequestForm) {
        log.info("trying to sign up");
        log.info(String.valueOf(signUpRequestForm));
        Member member = new Member(signUpRequestForm);
        memberMap.put(member.getId(), member);
        return member.getId();
    }
}
