package com.example.demo.lectureClass.authentication.github.service;

import com.example.demo.lectureClass.authentication.github.service.request.GithubOauthTokenRequest;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import com.example.demo.lectureClass.utility.property.PropertyUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubOauthServiceImpl implements GithubOauthService {
    private RestOperations restTemplate;
    final private PropertyUtil propertyUtil;

    @Override
    public String getAuthorizeCode() {
        final String CLIENT_ID = "yourGithubOAuthAppsId";
        final String URL = "https://github.com/login/oauth/authorize";

        // https://github.com/login/oauth/authorize?client_id=yourGithubOAuthAppsId&scope=repo:status read:repo_hook user:email
        return URL + "?client_id=" + CLIENT_ID + "&scope=repo:status read:repo_hook user:email";
    }

    @Override
    public String getAccessToken(String code) {
        final String REQUEST_GITHUB_ACCESS_TOKEN_URL =
                "https://github.com/login/oauth/access_token";
        final String CLIENT_ID = "yourGithubOAuthAppsId";
        final String YOUR_SECRETS = "";

        return restTemplate.postForObject(
                REQUEST_GITHUB_ACCESS_TOKEN_URL,
                new GithubOauthTokenRequest(CLIENT_ID, YOUR_SECRETS, code),
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