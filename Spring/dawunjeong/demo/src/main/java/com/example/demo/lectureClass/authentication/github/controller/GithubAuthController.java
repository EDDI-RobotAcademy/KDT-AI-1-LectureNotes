package com.example.demo.lectureClass.authentication.github.controller;

import com.example.demo.lectureClass.account.service.AccountService;
import com.example.demo.lectureClass.authentication.github.service.GithubOauthService;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import com.example.demo.lectureClass.authentication.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class GithubAuthController {

    final private GithubOauthService githubOauthService;
    final private AccountService accountService;
    final private RedisService redisService;

    @GetMapping("/github/login")
    public String requestGithubAuthorizeCode () {
        log.info("requestGithubAuthorizeCode()");

        return githubOauthService.getAuthorizeCode();
    }

    @GetMapping("/github/oauth-code")
    public String getGithubUserInfo(@RequestParam String code) {
        final Long NO_ACCOUNT = -1L;
        log.info("getGithubUserInfo(): " + code);

        String accessToken = githubOauthService.getAccessToken(code);
        log.info("accessToken: " + accessToken);

        GithubOauthAccountInfoResponse oauthAccountInfoResponse =
                githubOauthService.getAccountInfo(accessToken);

        String email = oauthAccountInfoResponse.getEmail();
        Long accountId = accountService.findAccountIdByEmail(email);

        if(accountId == NO_ACCOUNT){
            accountId = accountService.signUpWithEmail(email);
        }

        String userToken = UUID.randomUUID().toString();
        log.info("accountId: " + accountId + ", userToken: " + userToken);

        redisService.setKeyAndValue(userToken, accountId);

        return userToken;
    }
}
