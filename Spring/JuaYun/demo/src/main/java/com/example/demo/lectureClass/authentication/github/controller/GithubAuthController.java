package com.example.demo.lectureClass.authentication.github.controller;

import com.example.demo.lectureClass.account.service.AccountService;
import com.example.demo.lectureClass.authentication.github.service.GithubOauthService;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import com.example.demo.lectureClass.authentication.redis.RedisService;
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

    final private RedisService redisService;

    final private AccountService accountService;

    // Github OAuth 인증 과정 요약 정리
    // 1. 사용자가 깃헙 로그인 인증을 요청하면
    //    https://github.com/login/oauth/authorize?client_id=yourGithubOAuthAppsId&scope=repo:status read:repo_hook user:email
    //    위 URL 주소중 yourGithubOAuthAppsId에 Github OAuth Apps 에 있는 client_id를 넣어서 URL 요청
    // 2. 이 URL 을 요청하면 특정 사용자에게 권한 부여를 할 것이냐는 메세지가 화면에 보여짐
    // 3. 여기서 Authorize(권한부여) 를 누르면
    //    Github OAuth Apps 에 설정한 redirection URL 로 authorize code 가 전송됨
    // 4. 이 authorize code 값을 기반으로 다시 access token 을 요청해야함
    // 5. Access Token 을 요청할 때는
    //    https://github.com/login/oauth/access_token 주소에
    //    client_id와 위에서 확보하게된 authorize code,
    //    그리고 client_secrets 를 기반으로 Access Token 을 요청합니다.
    //    여기서 client_secrets 는 Github OAuth Apps 에서
    //    Generate a new client secret 을 눌러서 나타나는 값입니다.
    // 6. 최종적으로 Access Token 을 발급 받는데 잘 받았는지 확인하면 됩니다.


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
