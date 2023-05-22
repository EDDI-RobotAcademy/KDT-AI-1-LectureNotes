package com.example.demo.problem10.service;

import com.example.demo.problem10.controller.form.AccountWithRoleRequestForm;
import com.example.demo.problem10.controller.form.BusinessNumberRequestForm;
import com.example.demo.problem10.entity.Member;
import com.example.demo.problem10.entity.MemberRole;
import com.example.demo.problem10.entity.Role;
import com.example.demo.problem10.entity.RoleType;
import com.example.demo.problem10.repository.AccountRepository;
import com.example.demo.problem10.repository.AccountRoleRepository;
import com.example.demo.problem10.repository.MemberRoleRepository;
import com.example.demo.problem10.repository.RoleRepository;
import com.example.demo.problem17.controller.form.AccountLoginResponseForm;
import com.example.demo.problem17.controller.form.AccountRequestForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Override
    public Member registerWithRole(AccountWithRoleRequestForm requestForm) {
        final Optional<Member> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final Member member = accountRepository.save(requestForm.toAccount());

        final Role role = roleRepository.findByRoleType(
                (requestForm.getRoleType()));

        final MemberRole accountRole =
                new MemberRole(role, member);

        accountRoleRepository.save(accountRole);

        return member;
    }

    @Override
    public Member registerWithRoleAndNumber(AccountWithRoleRequestForm requestForm, String businessNumber) {
        final Optional<Member> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }

        final Member member = accountRepository.save(requestForm.toAccount());
        member.setBusinessNumber(businessNumber);

        final Role role = roleRepository.findByRoleType(
                (requestForm.getRoleType()));

        final MemberRole accountRole =
                new MemberRole(role, member);

        accountRoleRepository.save(accountRole);

        return member;
    }

    @Override
    public AccountLoginResponseForm login(AccountRequestForm requestForm) {
        final Optional<Member> maybeMember =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeMember.isEmpty()) {
            log.info("로그인 실패!");
            return new AccountLoginResponseForm(null);
        }

        Member member = maybeMember.get();

        if (member.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            MemberRole memberRole = memberRoleRepository.findByMember(member);
            if (memberRole.getRole().getRoleType().equals(RoleType.NORMAL)) {
                return new AccountLoginResponseForm(UUID.randomUUID());
            }
            if (memberRole.getRole().getRoleType().equals(RoleType.BUSINESS)) {
                return new AccountLoginResponseForm(UUID.randomUUID());
            }
        }

        return new AccountLoginResponseForm(null);
    }
}
