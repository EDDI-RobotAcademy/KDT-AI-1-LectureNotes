package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service;

import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemAccount;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemAccountRole;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity.ProblemRole;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.repository.ProblemAccountRepository;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.repository.ProblemAccountRoleRepository;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.repository.ProblemRoleRepository;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service.request.ProblemAccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProblemAccountServiceImpl implements ProblemAccountService{
    final private ProblemAccountRepository accountRepository;
    final private ProblemAccountRoleRepository accountRoleRepository;
    final private ProblemRoleRepository roleRepository;

    @Override
    public Boolean register(ProblemAccountRegisterRequest request) {
        ProblemAccount account = accountRepository.save(request.toProblemAccount());

        final ProblemRole role = roleRepository.findByRoleType(
                request.getRoleType()).get();
        final ProblemAccountRole accountRole =
                new ProblemAccountRole(account, role);
        accountRoleRepository.save(accountRole);

        account.setAccountRole(accountRole);

        return true;
    }
}
