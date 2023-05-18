package com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.repository;

import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.entity.TestBusinessAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestBusinessAccountRepository extends JpaRepository<TestBusinessAccount, Long> {

    Optional<TestBusinessAccount> findByEmail(String email);

}
