package com.example.demo.lectureClass.refactorAccount.repository;

import com.example.demo.lectureClass.refactorAccount.entity.RefactorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefactorAccountRepository extends JpaRepository<RefactorAccount,Long> {
}
