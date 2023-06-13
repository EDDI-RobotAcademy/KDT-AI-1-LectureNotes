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

    /*
        Github OAuth 인증 과정 요약 정리

        1. 사용자가 깃헙 로그인 인증을 요청하면
		https://github.com/login/oauth/authorize?client_id=yourGithubOAuthAppsId&scope=repo:status read:repo_hook user:email
		위 URL 주소 중 yourGithubOAuthAppsId에
		Github OAuth Apps에 있는 client_id를 넣어서 URL 요청

        2. 이 URL을 요청하면 특정 사용자에게 권한 부여를 할 것이냐는 메시지가 화면에 보여진다.

        3. 여기서 Authorize(권한 부여)를 누르면
            Github OAuth Apps에 설정한 redirection URL로 authorize code가 전송됨

        4. 이 authorize code 값을 기반으로 다시 access token을 요청해야함

        5. Access Token을 요청할 때는
           https://github.com/login/oauth/access_token 주소에
           client_id와 위에서 확보하게된 authorize code,
           그리고 client_secrets를 기반으로 Access Token을 요청합니다.
           여기서 client_secrets는 Github OAuth Apps에서
           Generate a new client secret을 눌러서 나타나는 값입니다.

        6. 최종적으로 Access Token을 발급 받는데 잘 받았는지 확인하면 됩니다.
    */

    @GetMapping("/github/oauth-code")
    public String getGithubUserInfo(@RequestParam String code) {
        final Long NO_ACCOUNT = -1L;

        log.info("getGithubUserInfo(): " + code);

        /*
            accessToken 는 Github 로 부터 AccessToken 을 부여받게 된다.
        */
        String accessToken = githubOauthService.getAccessToken(code);
        log.info("accessToken: " + accessToken);

        // accessToken 를 통해 깃허브에 연관된 정보를 얻게 된다.
        GithubOauthAccountInfoResponse oauthAccountInfoResponse =
                githubOauthService.getAccountInfo(accessToken);

        String email = oauthAccountInfoResponse.getEmail();
        /*
            깃허브에 해당 email 이 존재하면 id 를 가져오고
            존재하지 않으면 null 이 들어온다.
        */
        Long accountId = accountService.findAccountIdByEmail(email);

        if (accountId == NO_ACCOUNT) {
            log.info("ready to register new account!");
            accountId = accountService.signUpWithEmail(email);
        }


        String userToken = UUID.randomUUID().toString();
        log.info("accountId: " + accountId + ", userToken: " + userToken);

        /*
            임의로 백엔드에서 만들어준 userToken 값과
            깃허브 email 에 매치하는 accountId 를
            redis 에 배치해준다.
        */
        redisService.setKeyAndValue(userToken, accountId);

        return userToken;
    }
}
