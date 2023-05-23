package com.example.demo.lectureClass.fetchType.account.service;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.Role;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import com.example.demo.lectureClass.fetchType.account.repository.JpaAccountRepository;
import com.example.demo.lectureClass.fetchType.account.repository.JpaAccountRoleRepository;
import com.example.demo.lectureClass.fetchType.account.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaAccountServiceImpl implements JpaAccountService{

    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private JpaAccountRoleRepository accountRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm) {

        final Optional<JpaAccount> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());
        // 테스트 작성하고 Jpa환경 구성하면
        // 테스트 돌릴 때 자동으로 입력값이 DB에 저장됨 - 이때까지는 form형태

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }
        // 그러면 email 입력할 때 그 회원이 DB에 있는지 없는지 확인하고 있으면 null을 반환하여
        // 등록을 못하도록 하고 그럼 test는 fail
        // 없으면 등록할 수 있도록 하고 그럼 test는 pass

        final JpaAccount account = accountRepository.save(requestForm.toJpaAccount());
        // 회원들을 다 찾아와줬음
        // 이제 role저장소에 저장해준줄건데 뭘 저장해주지?
        // accout저장소에서 회원들 찾아왔으면 이제 role까지 갖춘 requestForm을 저장해줘야지
        // 그리고 그 form 형식으로 입력된 값을 엔티티 형식으로 맞춰서 DB에 저장하고

        // public JpaAccount toJpaAccount() {
        //    return new JpaAccount(email, password);
        // }
        // role없는 form을 entity형태로 맞춰서 먼저 저장해주고

//        accountRoleRepository.save(requestForm.toJpaAccountRole(account));
        // public JpaAccountRole toJpaAccountRole(JpaAccount account) {
        //     return new JpaAccountRole(role, account);
        // }

        // 여기서는 role이 추가되었기에 엔티티 형식으로 roleRepository에 한번 더 저장해줌
        // @ManyToOne(fetch = FetchType.LAZY)
        // private JpaAccount account;
        // 그러면 이 부분 때문에 테이블에서 account_id로 표현되는 것임
        // private JpaAccount jpaAccount;라고 하면
        // 테이블에서 jpa_account_id로 뜸!

        final Role role = roleRepository.findByRoleType(
                (requestForm.getRoleType()));



        final JpaAccountRole accountRole =
                new JpaAccountRole(role, account);

        accountRoleRepository.save(accountRole);

        return account;
        // 반환되는 account는 JpaAccount 엔티티에 구성되어 있는 값들만 보이는 것
    }

    @Override
    public List<JpaAccountResponseForm> accountListWithRole(String role) {
        final List<JpaAccountRole> matchedAccountRoleList = accountRoleRepository.findAllByRole(role);
        log.info("matchedAccountRoleList: " + matchedAccountRoleList);
        // 먼저 role저장소에서 role로 찾아오기
        // accountRoleRepository에서 매칭되는 애들 찾아와서 matchedAccountRoleList에 담음
        // 그 list를 accountRepository에 있는 애들과 매칭시켜야함
        // 그러면 account저장소의 id값과 맞는 애들을 찾아야 함

        List<JpaAccountResponseForm> responseFormList = new ArrayList<>();
        // JpaAccountResponseForm 타입의 리스트 만들어주고 거기에 일반회원들 담아줄 것임

        for (JpaAccountRole accountRole: matchedAccountRoleList) {
            // JpaAccountRole객체를 담고 있는 matchedAccountRoleList를 accountRole에 하나씩 담아줌
            final Optional<JpaAccount> maybeAccount = accountRepository.findById(accountRole.getId());
            // 그 accountRole에 해당하는 id가 accountRepository에 있는지 찾아라
            // role에 해당하는 애들로 찾아온 애들에 해당하는 id를 accountRepository에서 찾음

            if (maybeAccount.isEmpty()) {
                return null;
            }
            // 내가 찾는 id가 없다면 null을 반환해라

            final JpaAccount account = maybeAccount.get();

            responseFormList.add(
                    new JpaAccountResponseForm(account.getId(), account.getEmail()));
            // 찾는 id에 해당하는 id와 email을 폼 형태의 객체로 reponseFormList에 추가해라
        }

        return responseFormList;
    }
}
