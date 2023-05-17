package kr.eddi.demo.memberCode.member.service;

import kr.eddi.demo.memberCode.member.entity.TestMember;
import kr.eddi.demo.memberCode.member.repository.TestMemberRepository;

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
    public TestMember register(String id, String name, String password) {
        if(checkDuplicateOfMemberId(id) == false) {
            log.info("가입정보가 중복되었습니다.");
            return null;
        }
        final TestMember testMember = new TestMember(id, name, password);
        testMemberRepository.save(testMember);

        return testMember;
    }

    private Boolean checkDuplicateOfMemberId(String id) {
        final Optional<TestMember> maybeMemeber = testMemberRepository.findById(id);

        if(maybeMemeber.isPresent()) {
            return false;
        }

        return true;
    }
}
