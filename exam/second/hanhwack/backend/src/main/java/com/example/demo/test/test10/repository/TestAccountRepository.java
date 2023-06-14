package com.example.demo.test.test10.repository;


import com.example.demo.test.test10.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {

}