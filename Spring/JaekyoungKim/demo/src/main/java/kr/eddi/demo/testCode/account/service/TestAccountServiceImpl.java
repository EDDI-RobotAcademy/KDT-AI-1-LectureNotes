package kr.eddi.demo.testCode.account.service;

import kr.eddi.demo.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import kr.eddi.demo.testCode.account.entity.AccountRole;
import kr.eddi.demo.testCode.account.entity.TestAccount;
import kr.eddi.demo.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.testCode.account.repository.TestAccountRoleRepository;
import kr.eddi.demo.testCode.order.controller.form.TestAccountResponseForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {
    // 서비스에는 관련 저장소들이 다 생성되어야 한다.

    final private TestAccountRepository testAccountRepository;
    final private TestAccountRoleRepository testAccountRoleRepository;
    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {
        // 넘겨받은 이메일과 패스워드를 레포지토리에서 검색한다.
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());
        //래포지토리에서 검색해서 찾을 경우 어카운트가 생성되는 코드이다.
        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;// 생성 하려는 아이디가 이미 저장되어 있기 때문에 널을 리턴함
        }
        // 생성하려는 아이디가 래포지토리에 없기 때문에
        return testAccountRepository.save(requestForm.toTestAccount());
        // requestForm의 toTestAccount로 어카운트 생성한 후 래포지토리에 저장해준다.
    }

    @Override
    public TestAccountLoginResponseForm login(TestAccountRequestForm requestForm) {
        //리퀘스트 폼으로 넘어온 정보를 토대로 진행한다.
        final Optional<TestAccount> maybeAccount =
                // 어카운트 래포지토리에 해당 아이디가 있니? 있으면 가져와 보아라
                testAccountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            //어카운트가 비어있다면 틀린 아이디 보낸것이다.
            log.debug("로그인 실패!");
            return new TestAccountLoginResponseForm(null);
        }

        TestAccount account = maybeAccount.get();
        //아이디가 같을 경우 우선 계정을 생성한다.
        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");// 리퀘스트 폼에서 가져온 비밀번호와 래포지토리에서 가져온 비밀 번호가 같을 경우
            // 로그인 성공이다.
            return new TestAccountLoginResponseForm(UUID.randomUUID());
            //랜덤 식별자로 로그인 성공함
        }
        // 아이디는 같으나 비번이 틀리면 로그인 불가
        return new TestAccountLoginResponseForm(null);
    }

// 역할과 같이 가입하는 경우
    @Override
    public TestAccount registerWithRole(TestAccountWithRoleRequestForm requestForm) {
        // 받아온 폼으로 래포지토리에서 이메일로 검색해 본다. 이메일은 중복이 아니므로 pr key 가능하다.
        final Optional<TestAccount> maybeAccount =
                testAccountRepository.findByEmail(requestForm.getEmail());
        // 잇을 경우 있는 회원이므로 저장 불가
        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }
        // 래포지토리에서 못 찾을 경우에 신규 회원으로 가입 할 수 있다.

        final TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        // 리퀘스트의 toTestAccount() 메서드로 account 생성하고 저장한다.
        testAccountRoleRepository.save(requestForm.toTestAccountRole(account));
        // 어카운트 롤 래포지토리에  어카운트롸 롤을 갖고 있는 testAccountRole을 만들어서 저장한다.
        // 어카운트 리턴한다. 역할이 궁금한건 아니기 때문에
        return account;
    }

    @Override
    public List<TestAccountResponseForm> accountListWithRole(String role) {
        //특정 역할 조회하는 메서드이다.
        // 받아온 역할 현재는 비지니스로 하겠다.
        final List<AccountRole> matchedAccountRoleList=testAccountRoleRepository.findAllByRole(role);
        // testAccountRoleRepository에 존재하는 모든 비지니스 역할의 AccountRole 가져온다.
        List<TestAccountResponseForm> responseFormList=new ArrayList<>();
        // 반환할 정보인 비어있는 TestAccountResponseForm을 만들어준다.
        // 위의 리스트의 존재하는 숫자만큼 반복할 것이다.
        for (AccountRole accountRole: matchedAccountRoleList){
            //리스트에 존재하는 비지니스역하르이 어카운트들을 reponseForm에 다시 넣어준다.
            final TestAccount account= accountRole.getAccount();
            responseFormList.add(
                    new TestAccountResponseForm(account.getId(),account.getEmail())
                    // 비밀번호는 필요없기 때문에 id 와 email 만 리턴한다.
            );
        }
        return responseFormList;
        // 이제 리스트 리턴한다.
    }
}