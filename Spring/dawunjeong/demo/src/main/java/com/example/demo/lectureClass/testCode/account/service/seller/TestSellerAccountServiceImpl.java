package com.example.demo.lectureClass.testCode.account.service.seller;

import com.example.demo.lectureClass.testCode.account.controller.form.seller.TestSellerAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;
import com.example.demo.lectureClass.testCode.account.repository.seller.TestSellerAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestSellerAccountServiceImpl implements TestSellerAccountService {

    final private TestSellerAccountRepository testSellerAccountRepository;
    @Override
    public TestSellerAccount register(TestSellerAccountRequestForm requestForm) {
        final Optional<TestSellerAccount> maybeSellerAccount =
                testSellerAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeSellerAccount.isPresent()) {
            log.debug("이미 등록된 판매자입니다!");
            return null;
        }

        return testSellerAccountRepository.save(requestForm.toTestSellerAccount());
    }

    @Override
    public TestSellerAccount findSellerAccount(TestSellerAccountRequestForm requestForm) {
        final Optional<TestSellerAccount> maybeSellerAccount =
                testSellerAccountRepository.findByEmail(requestForm.getEmail());

        if(maybeSellerAccount.isPresent()) {
            return maybeSellerAccount.get();
        }
        return maybeSellerAccount.get();
    }
}
