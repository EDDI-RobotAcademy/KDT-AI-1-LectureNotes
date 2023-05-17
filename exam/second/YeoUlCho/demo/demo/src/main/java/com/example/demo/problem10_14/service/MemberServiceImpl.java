package com.example.demo.problem10_14.service;

import com.example.demo.login.LoginForm;
import com.example.demo.login.LoginResponseForm;
import com.example.demo.problem10_14.entity.Member;
import com.example.demo.problem10_14.entity.MemberRole;
import com.example.demo.problem10_14.entity.Role;
import com.example.demo.problem10_14.repository.MemberRepository;
import com.example.demo.problem10_14.repository.MemberRoleRepository;
import com.example.demo.problem10_14.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    final MemberRepository memberRepository;
    final MemberRoleRepository memberRoleRepository;
    final RoleRepository roleRepository;

    @Override
    public Member register(MemberRegisterRequest request) {
        Member member = memberRepository.save(request.toMember());

        final Role role = roleRepository.findByRoleType(
                request.getRoleType()).get();
        final MemberRole memberRole =
                new MemberRole(member, role);
        memberRoleRepository.save(memberRole);

        member.setAccountRole(memberRole);
        return member;

    }

    @Override
    public LoginResponseForm login(LoginForm loginForm) {
        log.info(loginForm.getEmail());
        Optional<Member> maybeMember = memberRepository.findByEmail(loginForm.getEmail());
        if(maybeMember.isEmpty()){
            log.info("로그인 실패");
            return null;
        }
        Member member = maybeMember.get();
        if(member.getPassword().equals(loginForm.getPassword())){
            log.info("로그인 성공");
            return new LoginResponseForm(1L);
        }
        return null;
    }
}
