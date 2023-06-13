package com.example.demo.problem10_14.service;

import com.example.demo.problem10_14.controller.form.TestBusinessRequestForm;
import com.example.demo.problem10_14.controller.form.TestNormalRequestForm;
import com.example.demo.problem10_14.entity.TestBusinessMember;
import com.example.demo.problem10_14.entity.TestMember;
import com.example.demo.problem10_14.repository.TestBusinessMemberRepository;
import com.example.demo.problem10_14.repository.TestMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements TestMemberService{

    final private TestMemberRepository testMemberRepository;
    final private TestBusinessMemberRepository testBusinessMemberRepository;


    @Override
    public TestMember registerNormalMember(TestNormalRequestForm requestForm) {
        final Optional<TestMember> maybeMember = testMemberRepository.findByEmail(requestForm.getEmail());

        if(maybeMember.isPresent()){
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testMemberRepository.save(requestForm.toTestAccount());
    }

    @Override
    public TestBusinessMember registerBusinessMember(TestBusinessRequestForm requestForm) {
        final Optional<TestBusinessMember> maybeMember = testBusinessMemberRepository.findByEmail(requestForm.getEmail());

        if (maybeMember.isPresent()){
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        return testBusinessMemberRepository.save(requestForm.toTestAccount());
    }
}
