package com.example.demo.lectureClass.testCode.account.repository;

import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
}
