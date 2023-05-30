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
    public void getGithubUserInfo(@RequestParam String code) {
        log.info("getGithubUserInfo(): " + code);

        String accessToken = githubOauthService.getAccessToken(code);
        log.info("accessToken: " + accessToken);

        GithubOauthAccountInfoResponse oauthAccountInfoResponse =
                githubOauthService.getAccountInfo(accessToken);

        String email = oauthAccountInfoResponse.getEmail();
        Long accountId = accountService.findAccountIdByEmail(email);
        UUID userToken = UUID.randomUUID();
        log.info("accountId: " + accountId + ", userToken: " + userToken);

        redisService.setKeyAndValue(userToken.toString(), accountId);
    }
}
