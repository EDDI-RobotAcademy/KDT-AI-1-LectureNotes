package com.example.demo.lectureClass.testCode.member.service;

import com.example.demo.lectureClass.testCode.member.entity.TestMember;
import com.example.demo.lectureClass.testCode.member.repository.TestMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements TestMemberService {
    final private TestMemberRepository memberRepository;
    @Override
    public TestMember register(TestMember testMember) {
        final Optional<TestMember> maybeMember = memberRepository.findByEmail(testMember.getEmail());

        if(maybeMember.isPresent()) {
            log.info("동일 이메일이 존재합니다!");
            return null;
        }
        return memberRepository.save(testMember);
    }
}
