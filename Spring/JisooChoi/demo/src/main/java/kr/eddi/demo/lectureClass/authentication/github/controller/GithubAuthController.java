package kr.eddi.demo.lectureClass.authentication.github.controller;

import kr.eddi.demo.lectureClass.account.service.AccountService;
import kr.eddi.demo.lectureClass.authentication.github.service.GithubOauthService;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import kr.eddi.demo.lectureClass.authentication.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    // Github OAuth 인증 과정 요약 정리 --> 내 노션에 정리해뒀음

    @GetMapping("/github/oauth-code")
    public String getGithubUserInfo(@RequestParam String code) {
        final Long NO_ACCOUNT = -1L;

        log.info("getGithubUserInfo(): " + code);

        /*
            accessToken 는
            restTemplate.postForObject(...)를 반환받는다.
        */
        String accessToken = githubOauthService.getAccessToken(code);
        log.info("accessToken: " + accessToken);

        GithubOauthAccountInfoResponse oauthAccountInfoResponse =
                githubOauthService.getAccountInfo(accessToken);

        String email = oauthAccountInfoResponse.getEmail();
        Long accountId = accountService.findAccountIdByEmail(email);

        if (accountId == NO_ACCOUNT) {
            log.info("ready to register new account!");
            accountId = accountService.signUpWithEmail(email);
        }


        String userToken = UUID.randomUUID().toString();
        log.info("accountId: " + accountId + ", userToken: " + userToken);

        redisService.setKeyAndValue(userToken, accountId);

        return userToken;
    }
}
