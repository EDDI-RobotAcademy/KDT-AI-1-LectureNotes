package com.example.demo.lectureClass.authentication.github.controller;

import com.example.demo.lectureClass.authentication.github.service.GithubOauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class GithubAuthController {

    final private GithubOauthService githubOauthService;

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
    }
}
