package com.example.demo.lectureClass.authentication.github.service;

public interface GithubOauthService {
    String getAuthorizeCode();

    String getAccessToken(String code);
}
