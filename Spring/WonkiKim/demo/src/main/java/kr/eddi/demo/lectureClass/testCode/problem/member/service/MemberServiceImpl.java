package kr.eddi.demo.lectureClass.testCode.problem.member.service;

import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.problem.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final private MemberRepository memberRepository;
    @Override
    public Member register(Member member) {
        final Optional<Member> maybeMember = memberRepository.findByEmail(member.getEmail());
        if (maybeMember.isPresent()) {
            log.info("동일한 계정명의 회원이 존재합니다.");
            return null;
        }
        return memberRepository.save(member);
    }

    @Override
    public MemberResponseForm logIn(Member member) {
        final Optional<Member> maybeMember = memberRepository.findByEmail(member.getEmail());
        if(maybeMember.isEmpty()) {
            log.info("계정아이디가 다릅니다");
            return new MemberResponseForm(null);
        }
        if(maybeMember.get().getPassword().equals(member.getPassword())) {
            return new MemberResponseForm(UUID.randomUUID());
        }
        log.info("비밀번호가 다릅니다");
        return new MemberResponseForm(null);
    }
}
