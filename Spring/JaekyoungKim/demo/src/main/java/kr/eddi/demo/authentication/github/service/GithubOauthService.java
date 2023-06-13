package kr.eddi.demo.authentication.github.service;

import kr.eddi.demo.authentication.github.service.reponse.GithubOauthAccountInfoResponse;


public interface GithubOauthService {
    String getAuthorizeCode();

    String getAccessToken(String code);

    GithubOauthAccountInfoResponse getAccountInfo(String accessToken);
}