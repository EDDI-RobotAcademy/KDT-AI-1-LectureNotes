package com.example.demo.lectureClass.authentication.github.service;

import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;

public interface GithubOauthService {
    String getAuthorizeCode();

    String getAccessToken(String code);

    GithubOauthAccountInfoResponse getAccountInfo(String accessToken);
}