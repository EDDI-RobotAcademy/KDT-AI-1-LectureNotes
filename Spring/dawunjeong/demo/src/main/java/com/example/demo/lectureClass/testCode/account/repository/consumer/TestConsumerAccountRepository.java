package com.example.demo.lectureClass.testCode.account.repository.consumer;

import com.example.demo.lectureClass.testCode.account.entity.consumer.TestConsumerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestConsumerAccountRepository extends JpaRepository<TestConsumerAccount, Long> {
    Optional<TestConsumerAccount> findByEmail(String email);
}
