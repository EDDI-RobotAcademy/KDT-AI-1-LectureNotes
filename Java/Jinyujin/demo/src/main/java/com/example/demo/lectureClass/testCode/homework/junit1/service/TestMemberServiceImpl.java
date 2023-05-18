package com.example.demo.lectureClass.testCode.homework.junit1.service;

import com.example.demo.lectureClass.testCode.homework.junit1.repository.TestMemberRepository;
import com.example.demo.lectureClass.testCode.homework.junit1.entity.TestMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements TestMemberService{

    final TestMemberRepository memberRepository;

    @Override
    public TestMember register(TestMember testMember) {

        final Optional<TestMember> maybeMember =
                memberRepository.findByName(testMember.getName());

        if (maybeMember.isPresent()) {
            log.info("동일 이름이 존재합니다!");
            return null;
        }

        return memberRepository.save(testMember);
    }
}
