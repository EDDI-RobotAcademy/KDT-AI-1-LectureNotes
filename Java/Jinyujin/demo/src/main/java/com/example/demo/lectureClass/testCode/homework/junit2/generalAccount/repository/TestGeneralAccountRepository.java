package com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.repository;

import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestGeneralAccountRepository extends JpaRepository<TestGeneralAccount, Long> {

    Optional<TestGeneralAccount> findByEmail(String email);

}
