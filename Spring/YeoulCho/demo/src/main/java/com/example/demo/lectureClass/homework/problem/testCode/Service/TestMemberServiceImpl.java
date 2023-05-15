package com.example.demo.lectureClass.homework.problem.testCode.Service;

import com.example.demo.lectureClass.homework.problem.testCode.entity.TestMember;
import com.example.demo.lectureClass.homework.problem.testCode.repository.TestMemberRepository;
import com.example.demo.lectureClass.testCode.student.entity.TestStudent;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements TestMemberService{
    final private TestMemberRepository memberRepository;
    @Override
    public TestMember register(TestMember testMember){

        final Optional<TestMember> maybeMember =
                memberRepository.findByMemberEmail(testMember.getMemberEmail());
        if(maybeMember.isPresent()){
            log.info("동일 닉네임의 학생이름이 존재합니다.");
            return null;
        }
        return memberRepository.save(testMember);
    }
}
