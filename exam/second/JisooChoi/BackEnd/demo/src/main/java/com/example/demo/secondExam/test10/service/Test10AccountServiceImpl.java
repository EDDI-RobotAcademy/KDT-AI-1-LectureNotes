package com.example.demo.secondExam.test10.service;

import com.example.demo.secondExam.test10.controller.form.Test10AccountRequestForm;
import com.example.demo.secondExam.test10.controller.form.Test17AccountLoginResponseForm;
import com.example.demo.secondExam.test10.entity.Test10Account;
import com.example.demo.secondExam.test10.repository.Test10AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class Test10AccountServiceImpl implements Test10AccountService{

    @Autowired
    private Test10AccountRepository accountRepository;

    @Override
    public Test10Account register(Test10AccountRequestForm requestForm){
        final Optional<Test10Account> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isPresent()){
            log.debug("이미 존재하는 회원입니다.");
            return null;
        }
        return accountRepository.save(requestForm.toTest10Account());
    }

    @Override
    public Test17AccountLoginResponseForm login(Test10AccountRequestForm requestForm){
        final Optional<Test10Account> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isEmpty()){
            log.debug("존재하지 않는 회원입니다.");
            return new Test17AccountLoginResponseForm(null, null);
        }

        Test10Account account = maybeAccount.get();

        if(account.getPassword().equals(requestForm.getPassword())){
            log.debug("로그인 성공!");
            return new Test17AccountLoginResponseForm(UUID.randomUUID(), requestForm.getRole());
        }

        log.debug("존재하지 않는 회원입니다.");
        return new Test17AccountLoginResponseForm(null, null);
    }

}
