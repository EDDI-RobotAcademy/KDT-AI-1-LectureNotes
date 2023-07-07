package kr.eddi.demo.lectureClass.authentication.github.service;

import kr.eddi.demo.lectureClass.authentication.github.service.request.GithubOauthTokenRequest;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import kr.eddi.demo.lectureClass.utility.property.PropertyUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubOauthServiceImpl implements GithubOauthService {

    final private RestTemplate restTemplate;
    final private PropertyUtil propertyUtil;

    @Override
    public String getAuthorizeCode() {
        final String CLIENT_ID = propertyUtil.getProperty("client_id");
        final String URL = "https://github.com/login/oauth/authorize";
        final String fullUrl = URL + "?client_id=" + CLIENT_ID + "&scope=repo:status read:repo_hook user:email";

        return URL + "?client_id=" + CLIENT_ID + "&scope=repo:status read:repo_hook user:email";
    }

    @Override
    public String getAccessToken(String code) {
        final String REQUEST_GITHUB_ACCESS_TOKEN_URL =
                "https://github.com/login/oauth/access_token";
        final String CLIENT_ID = propertyUtil.getProperty("client_id");
        final String CLIENT_SECRETS = propertyUtil.getProperty("client_secrets");

        return restTemplate.postForObject(
                REQUEST_GITHUB_ACCESS_TOKEN_URL,
                new GithubOauthTokenRequest(CLIENT_ID, CLIENT_SECRETS, code),
                GithubOauthAccessTokenResponse.class).getAccessToken();
    }

    @Override
    public GithubOauthAccountInfoResponse getAccountInfo(String accessToken) {
        final String REQUEST_GITHUB_USER_API_URL =
                "https://api.github.com/user";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        GithubOauthAccountInfoResponse response = restTemplate.exchange(
                REQUEST_GITHUB_USER_API_URL,
                HttpMethod.GET,
                request,
                GithubOauthAccountInfoResponse.class).getBody();

        log.info("result: " + response);

        return response;
    }
}
