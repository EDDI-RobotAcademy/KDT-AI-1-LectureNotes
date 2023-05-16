package kr.eddi.demo.lectureClass.testCode.member.service;

import kr.eddi.demo.lectureClass.testCode.member.entity.TestMember;
import kr.eddi.demo.lectureClass.testCode.member.repository.TestMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements TestMemberService{
    final private TestMemberRepository testMemberRepository;

    @Override
    public void register(TestMember testMember) {
        Optional<TestMember> maybeTestMember = testMemberRepository.findByMemberName(testMember.getMemberName());
        if(maybeTestMember.isPresent()){
            System.out.println("중복 있음");
            return;
        }

        testMemberRepository.save(testMember);
    }
}
