package kr.eddi.demo.lectureClass.authentication.github.service;

import kr.eddi.demo.lectureClass.authentication.github.service.request.GithubOauthTokenRequest;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubOauthServiceImpl implements GithubOauthService {

    final private RestTemplate restTemplate;

    @Override
    public String getAuthorizeCode() {
        final String CLIENT_ID = "5d0ba68c3b0fe066ffc0";
        final String URL = "https://github.com/login/oauth/authorize";

        // https://github.com/login/oauth/authorize?client_id=yourGithubOAuthAppsId&scope=repo:status read:repo_hook user:email
        return URL + "?client_id=" + CLIENT_ID + "&scope=repo:status read:repo_hook user:email";
    }

    @Override
    public String getAccessToken(String code) {
        final String REQUEST_GITHUB_ACCESS_TOKEN_URL =
                "https://github.com/login/oauth/access_token";
        final String CLIENT_ID = "5d0ba68c3b0fe066ffc0";
        final String YOUR_SECRETS = "1ff3a3635047d921fe2912376b4ec890a498da6a";

        return restTemplate.postForObject(
                REQUEST_GITHUB_ACCESS_TOKEN_URL,
                new GithubOauthTokenRequest(CLIENT_ID, YOUR_SECRETS, code),
                GithubOauthAccessTokenResponse.class).getAccessToken();
    }
}