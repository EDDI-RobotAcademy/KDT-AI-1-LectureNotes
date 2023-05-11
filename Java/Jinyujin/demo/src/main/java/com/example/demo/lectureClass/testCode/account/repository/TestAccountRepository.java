package com.example.demo.lectureClass.testCode.account.repository;

import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
    Optional<TestAccount> findByEmail(String email);
    // 여기서 findBy~는 내가 설정한 변수명이랑 반드시 일치시켜줘야 함!!!
    // 안그러면 no property 'xxx' found for type 'xxx' 오류 발생할 수 있음
    // 만약 findByName(String productName)으로 하면 얘는 name을 찾으려고 하는데 productName만 있어서
    // name 없어서 못 찾겠다는 오류가 뜨는 것
}
