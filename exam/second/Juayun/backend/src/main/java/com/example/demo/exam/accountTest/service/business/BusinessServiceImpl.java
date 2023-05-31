package com.example.demo.exam.accountTest.service.business;

import com.example.demo.exam.accountTest.controller.request.business.BusinessLoginRequest;
import com.example.demo.exam.accountTest.controller.request.business.BusinessRegisterRequest;
import com.example.demo.exam.accountTest.entity.Role;
import com.example.demo.exam.accountTest.entity.business.BusinessAccount;
import com.example.demo.exam.accountTest.entity.business.BusinessAccountRole;
import com.example.demo.exam.accountTest.repository.RoleRepository;
import com.example.demo.exam.accountTest.repository.UserTokenRepository;
import com.example.demo.exam.accountTest.repository.UserTokenRepositoryImpl;
import com.example.demo.exam.accountTest.repository.business.BusinessRepository;
import com.example.demo.exam.accountTest.repository.business.BusinessRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    final private BusinessRepository businessRepository;
    final private RoleRepository roleRepository;
    final private BusinessRoleRepository businessRoleRepository;

    final private UserTokenRepository userTokenRepository = UserTokenRepositoryImpl.getInstance();

    @Override
    public Boolean register(BusinessRegisterRequest toBusinessRegisterRequest) {
        // 여기서 등록해야 하는 것 roleType, businessCode, businessAccount, businessAccountRole

        BusinessAccount businessAccount =
                businessRepository.save(toBusinessRegisterRequest.toBusinessAccount());

        final Role role =
                roleRepository.findByRoleType(toBusinessRegisterRequest.getRoleType()).get();

        final BusinessAccountRole businessAccountRole = new BusinessAccountRole(businessAccount, role);
        businessRoleRepository.save(businessAccountRole);

        businessAccount.setBusinessRole(businessAccountRole);

        return true;
    }

    @Override
    public String login(BusinessLoginRequest toBusinessLoginRequest) {
        final Optional<BusinessAccount> maybeBusinessAccount =
                businessRepository.findByEmail(toBusinessLoginRequest.getEmail());
        if (maybeBusinessAccount.isEmpty()) {
            return null;
        }

        final BusinessAccount businessAccount = maybeBusinessAccount.get();
        if (businessAccount.getPassword().equals(toBusinessLoginRequest.getPassword())) {
            final String userToken = UUID.randomUUID().toString();
            userTokenRepository.save(userToken, businessAccount.getId());

            return userToken;
        }
        return null;
    }
}
