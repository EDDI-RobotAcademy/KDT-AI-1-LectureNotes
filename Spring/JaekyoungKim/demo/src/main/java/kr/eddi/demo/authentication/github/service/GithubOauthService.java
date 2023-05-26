package kr.eddi.demo.authentication.github.service;

public interface GithubOauthService {
    String getAuthorizeCode();

    String getAccessToken(String code);
}