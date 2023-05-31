package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.problemGithub.controller;

import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import kr.eddi.demo.lectureClass.authentication.redis.RedisService;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.problemGithub.service.ProblemGithubOauthService;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.problemGithub.service.response.ProblemGithubOauthAccountInfoResponse;
import kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.service.ProblemAccountService;
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
@RequestMapping("/problem-authentication")
public class ProblemGithubAuthController {
    final private ProblemGithubOauthService githubOauthService;
    final private ProblemAccountService accountService;
    final private RedisService redisService;

    @GetMapping("/github/login")
    public String requestGithubAuthorizeCode () {
        log.info("requestGithubAuthorizeCode()");

        return githubOauthService.getAuthorizeCode();
    }

    @GetMapping("/github/oauth-code")
    public String getGithubUserInfo(@RequestParam String code) {
        log.info("getGithubUserInfo(): " + code);
        final Long NO_ACCOUNT = -1L;

        String accessToken = githubOauthService.getAccessToken(code);
        log.info("accessToken: " + accessToken);

        ProblemGithubOauthAccountInfoResponse oauthAccountInfoResponse =
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
