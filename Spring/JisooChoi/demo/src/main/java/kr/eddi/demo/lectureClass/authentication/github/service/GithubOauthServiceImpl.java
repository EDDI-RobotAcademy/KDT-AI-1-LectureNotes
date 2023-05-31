package kr.eddi.demo.lectureClass.authentication.github.service;

import kr.eddi.demo.lectureClass.authentication.github.service.request.GithubOauthTokenRequest;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import kr.eddi.demo.lectureClass.utility.PropertyUtil;
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
public class GithubOauthServiceImpl implements GithubOauthService {

    final private RestTemplate restTemplate;
    final private PropertyUtil propertyUtil;

    @Override
    public String getAuthorizeCode() {
        final String CLIENT_ID = propertyUtil.getProperty("client_id");
        final String URL = "https://github.com/login/oauth/authorize";

        // https://github.com/login/oauth/authorize?client_id=yourGithubOAuthAppsId&scope=repo:status read:repo_hook user:email
        return URL + "?client_id=" + CLIENT_ID + "&scope=repo:status read:repo_hook user:email";
    }

    @Override
    public String getAccessToken(String code) {
        final String REQUEST_GITHUB_ACCESS_TOKEN_URL =
                "https://github.com/login/oauth/access_token";

        /*
            CLIENT_ID : 내 깃허브 OAuth 의 CLIENT_ID
            CLIENT_SECRETS : 내 깃허브 OAuth 의 CLIENT_SECRETS
        */
        final String CLIENT_ID = propertyUtil.getProperty("client_id");
        final String CLIENT_SECRETS = propertyUtil.getProperty("client_secrets");

        /*
            Q. restTemplate ?
                A. rest api 호출 이후 응답을 받을 때까지 기다리는 동기 방식이다.
                http 통신에 유용하게 쓸 수 있는 템플릿이며,
                HTTP 서버와의 통신을 단순화하고, RESTful 원칙을 지킨다. (json, xml)

            Q. postForObject ?
                A. URL 주소로 POST 요청을 보내고 객체로 결과를 반환받는다.
        */
        return restTemplate.postForObject(
                REQUEST_GITHUB_ACCESS_TOKEN_URL,
                new GithubOauthTokenRequest(CLIENT_ID, CLIENT_SECRETS, code), // Github 토큰의 완전체 모습같음 ..
                GithubOauthAccessTokenResponse.class).getAccessToken();
        /*
                Q. 위의 코드에서 사용하는 .class 의 용도가 무엇인가 ?
                (위의 return 형태가 너무 어려움)
        */

    }

    @Override
    public GithubOauthAccountInfoResponse getAccountInfo(String accessToken) {
        final String REQUEST_GITHUB_USER_API_URL =
                "https://api.github.com/user";

        /*
            HTTP 헤더는 클라이언트와 서버가 요청 또는 응답으로
            부가적인 정보를 전송할 수 있도록 한다.
        */
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
