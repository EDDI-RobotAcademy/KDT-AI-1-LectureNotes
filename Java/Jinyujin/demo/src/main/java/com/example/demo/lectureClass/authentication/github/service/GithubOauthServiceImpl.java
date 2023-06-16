package com.example.demo.lectureClass.authentication.github.service;

import com.example.demo.lectureClass.authentication.github.service.request.GithubOauthTokenRequest;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import com.example.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import com.example.demo.lectureClass.utility.property.PropertyUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubOauthServiceImpl implements GithubOauthService{

    final private RestTemplate restTemplate;
    final private PropertyUtil propertyUtil;

    @Override
    public String getAuthorizeCode() {
        final String CLIENT_ID = propertyUtil.getProperty("client_id");
        // github.properties에 있는 client_id를 가져와서 CLIENT_ID에 담을 수 있음
        final String URL = "https://github.com/login/oauth/authorize";

        // https://github.com/login/oauth/authorize?client_id=yourGithubOAuthAppsId&scope=repo:status read:repo_hook user:email
        return URL + "?client_id=" + CLIENT_ID + "&scope=repo:status read:repo_hook user:email";
    }

    @Override
    public String getAccessToken(String code) {
        final String REQUEST_GITHUB_ACCESS_TOKEN_URL =
                "https://github.com/login/oauth/access_token";
        final String CLIENT_ID = propertyUtil.getProperty("client_id");
        final String CLIENT_SECRETS = propertyUtil.getProperty("client_secrets");

        return restTemplate.postForObject(
                // restTemplate.postForObject(): restTmplate 내부에 있는 메서드
                // HTTP POST 요청을 보내고, 응답을 받아 자동으로 객체로 변환하는 기능
                // 이를 통해 API 서버와의 통신을 간단하게 처리
                // 내가 카카오 맵을 쓸 때 나는 음식점을 검색했을 때
                // 음식점 위치들의 데이터들을 반환해주는 게 스프링
                // 그 음식점 데이터들을 반환해주는 게 API
                REQUEST_GITHUB_ACCESS_TOKEN_URL,
                new GithubOauthTokenRequest(CLIENT_ID, CLIENT_SECRETS, code),
                GithubOauthAccessTokenResponse.class).getAccessToken();
                /*
                    REQUEST_GITHUB_ACCESS_TOKEN_URL,
                    new GithubOauthTokenRequest(CLIENT_ID, CLIENT_SECRETS, code),
                    GithubOauthAccessTokenResponse.class)
                    얘네들을 HTTP POST로 요청을 보내고 accessToken을 응답받는 것

                    GithubOauthAccessTokenResponse.class
                    Github API에서 Access Token 요청에 대한 응답을 받을 때 사용되는 클래스
                    -> Github API에서 반환하는 JSON 응답을 자동으로 객체로 변환해주는 역할
                */
    }

    @Override
    public GithubOauthAccountInfoResponse getAccountInfo(String accessToken) {
        final String REQUEST_GITHUB_USER_API_URL =
                "https://api.github.com/user";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        // 서버 측에서 인증된 사용자인지 토큰으로 확인하도록
        HttpEntity<Void> request = new HttpEntity<>(headers);

        GithubOauthAccountInfoResponse response = restTemplate.exchange(
                REQUEST_GITHUB_USER_API_URL,
                HttpMethod.GET,
                request,
                GithubOauthAccountInfoResponse.class).getBody();
        // 원래 accessToken으로 회원 정보를 받아오는 코드 형식 같음

        log.info("result: " + response);

        return response;
    }
}
