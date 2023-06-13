package com.example.demo.problem10_14.service;

import com.example.demo.login.LoginForm;
import com.example.demo.login.LoginResponseForm;
import com.example.demo.problem10_14.entity.Member;


public interface MemberService {
    Member register(MemberRegisterRequest request);
    LoginResponseForm login(LoginForm loginForm);

}
