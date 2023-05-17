package com.example.demo.lectureClass.testCode.account.repository.seller;

import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestSellerAccountRepository extends JpaRepository<TestSellerAccount, Long> {
    Optional<TestSellerAccount> findByEmail(String email);
}
