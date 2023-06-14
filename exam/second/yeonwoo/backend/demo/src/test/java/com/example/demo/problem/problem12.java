package com.example.demo.problem;

import com.example.demo.problem.entity.AccountRole;
import com.example.demo.problem.entity.RoleType;
import com.example.demo.problem.form.AccountRegisterRequestForm;
import com.example.demo.problem.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem.entity.RoleType.BUSINESS;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class problem12 {

    @Autowired
    private AccountService accountService;

}

