package com.example.demo.Problem10SignIn.repository;

import com.example.demo.Problem10SignIn.entity.AccountCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountCategoryRepository extends JpaRepository<AccountCategory, Long> {
}
