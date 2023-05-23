package kr.eddi.demo.lectureClass.testCode.problem.member.service;

import jakarta.transaction.Transactional;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.LogInResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.MemberRole;
import kr.eddi.demo.lectureClass.testCode.problem.member.repository.MemberRepository;
import kr.eddi.demo.lectureClass.testCode.problem.member.repository.MemberRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final private MemberRepository memberRepository;
    final private MemberRoleRepository memberRoleRepository;
    @Override
    public Member register(MemberRequestForm memberRequestForm) {
        final Optional<Member> maybeMember = memberRepository.findByEmail(memberRequestForm.getEmail());

        if (maybeMember.isPresent()) {
            log.info("동일한 계정명의 회원이 존재합니다.");
            return null;
        }
        Member member = memberRepository.save(memberRequestForm.toMember());
        memberRoleRepository.save(new MemberRole(memberRequestForm.getMemberRole(), member));
        return memberRepository.save(member);

    }

    @Override
    public LogInResponseForm logIn(Member member) {
        final Optional<Member> maybeMember = memberRepository.findByEmail(member.getEmail());
        if(maybeMember.isEmpty()) {
            log.info("계정아이디가 다릅니다");
            return new LogInResponseForm(null);
        }
        if(maybeMember.get().getPassword().equals(member.getPassword())) {
            return new LogInResponseForm(UUID.randomUUID());
        }
        log.info("비밀번호가 다릅니다");
        return new LogInResponseForm(null);
    }

    @Override
    @Transactional
    public List<MemberResponseForm> serchByRole(String role) {
        List<MemberResponseForm> memberResponseFormList = memberRoleRepository.findAllByRole(role)
                .stream()
                .map((MemberRole::getMember))
                .map((member)->new MemberResponseForm(member.getId(), member.getEmail()))
                .toList();
        return memberResponseFormList;
    }
}
