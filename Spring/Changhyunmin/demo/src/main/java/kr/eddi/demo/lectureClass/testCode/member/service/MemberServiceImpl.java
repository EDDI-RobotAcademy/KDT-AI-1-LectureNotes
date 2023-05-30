package kr.eddi.demo.lectureClass.testCode.member.service;

import kr.eddi.demo.lectureClass.testCode.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final private MemberRepository memberRepository;
    @Override
    public Member register(Member member) {
        final Optional<Member> maybeMember =
                memberRepository.findByMemberName(member.getMemberName());
        if (maybeMember.isPresent()) {
            log.info("아이디가 존재 합니다!");
            return null;
        }
        return memberRepository.save(member);
    }
}
