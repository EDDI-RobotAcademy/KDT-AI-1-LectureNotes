package com.example.demo.Problem10SignIn.service;

import com.example.demo.Problem10SignIn.controller.form.AccountLoginRequestForm;
import com.example.demo.Problem10SignIn.controller.form.AccountLoginResponseForm;
import com.example.demo.Problem10SignIn.controller.form.AccountRequestForm;
import com.example.demo.Problem10SignIn.entity.*;
import com.example.demo.Problem10SignIn.repository.*;
import com.example.demo.Problem10SignIn.service.request.AccountLoginRequest;
import com.example.demo.Problem10SignIn.service.request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.example.demo.Problem10SignIn.entity.CategoryType.BUSINESS;
import static com.example.demo.Problem10SignIn.entity.CategoryType.NORMAL;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountCategoryRepository accountCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BusinessNumberRepository businessNumberRepository;
    @Autowired
    private AccountBusinessNumberRepository accountBusinessNumberRepository;

    @Override
    public Boolean register(AccountRequest request) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(request.getEmail());

        if (maybeAccount.isPresent()) {
            return false;
        }

        final Account account = request.toAccount();
            accountRepository.save(account);

            final Category category = categoryRepository.findByCategoryType(request.getCategoryType());
            final AccountCategory accountCategory = new AccountCategory(account, category);
            accountCategoryRepository.save(accountCategory);

//            final BusinessNumber businessNumber = businessNumberRepository.findByBusinessNumber(request.getBusinessNumber());
            final BusinessNumber businessNumber = new BusinessNumber(request.getBusinessNumber());
            businessNumberRepository.save(businessNumber);

            final AccountBusinessNumber accountBusinessNumber = new AccountBusinessNumber(account, businessNumber);
            accountBusinessNumberRepository.save(accountBusinessNumber);
            return true;
    }

    @Override
    public AccountLoginResponseForm login(AccountLoginRequest request) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(request.getEmail());
        if (maybeAccount.isEmpty()) {
            return null;
        }
        if (maybeAccount.get().getPassword() != request.getPassword()){
            return null;
        }

        return request.toAccountLoginResponseForm();
    }
}
