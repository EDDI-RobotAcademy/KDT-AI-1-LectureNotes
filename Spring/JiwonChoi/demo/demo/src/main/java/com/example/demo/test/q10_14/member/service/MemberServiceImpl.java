package com.example.demo.test.q10_14.member.service;

import com.example.demo.test.q10_14.member.controller.form.BusinessMemberForm;
import com.example.demo.test.q10_14.member.controller.form.MemberForm;
import com.example.demo.test.q10_14.member.entity.BusinessMember;
import com.example.demo.test.q10_14.member.entity.Member;
import com.example.demo.test.q10_14.member.repository.BusinessMemberRepository;
import com.example.demo.test.q10_14.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final MemberRepository memberRepository;
    final BusinessMemberRepository businessMemberRepository;

    @Override//일반 회원가입
    public Member register(MemberForm memberForm) {
        Member member = memberForm.toMember();
        memberRepository.save(member);
        return member;
    }

    @Override //사업자 회원가입
    public void businessRegister(BusinessMemberForm businessMemberForm) {
        BusinessMember businessMember = businessMemberForm.toBusinessMember();
        businessMemberRepository.save(businessMember);
    }

    @Override //일반회원 로그인
    public Member login(MemberForm memberForm) {
        final Optional<Member> maybeMember = memberRepository.findByEmail(memberForm.getEmail());
        if(maybeMember.isEmpty()) {
            log.debug("존재하지 않는 이메일입니다.");
            return null;
        }
        String memberPassword = maybeMember.get().getPassword();
        if(memberPassword.equals(memberForm.getPassword())) {
            log.debug("로그인 되었습니다.");
        }
        return null;
    }
}

