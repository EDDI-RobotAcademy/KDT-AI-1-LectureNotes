package kr.eddi.demo.lectureClass.testCode.member.service;

import kr.eddi.demo.lectureClass.testCode.member.entity.TestMember;
import kr.eddi.demo.lectureClass.testCode.member.repository.TestMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements TestMemberService{
    final private TestMemberRepository testMemberRepository;

    @Override
    public TestMember register (TestMember testMember) {
        final Optional<TestMember> maybeMember =
                testMemberRepository.findByMemberName(testMember.getMemberName());
            if (maybeMember.isPresent()) {
                log.info("아이디가 존재 합니다!");
                return null;
            }
        return testMemberRepository.save(testMember);
    }

}
