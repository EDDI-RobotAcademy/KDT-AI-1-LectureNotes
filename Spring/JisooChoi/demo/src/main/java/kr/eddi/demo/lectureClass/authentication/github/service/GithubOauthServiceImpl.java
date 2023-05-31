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
        /*
            ★ 이 메서드의 전체적인 코드 흐름은

            Github 에 권한 인증(?) 을 받은 code 를 보내주고,
            (= Authorization code 를 보내서)

            AccessToken 요청을 한다.
         */
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
                REQUEST_GITHUB_ACCESS_TOKEN_URL, // 요청할 주소
                new GithubOauthTokenRequest(CLIENT_ID, CLIENT_SECRETS, code), // Github 토큰의 완전체 모습을 가지고
                GithubOauthAccessTokenResponse.class).getAccessToken(); // 해당 타입으로 리턴 받겠다.

    }

    @Override
    public GithubOauthAccountInfoResponse getAccountInfo(String accessToken) {
        final String REQUEST_GITHUB_USER_API_URL =
                "https://api.github.com/user";

        /*
            HTTP 헤더는 클라이언트와 서버가 요청 또는 응답으로
            부가적인 정보를 전송할 수 있도록 한다.

            HTTP POST 를 요청할 때 보내는
            데이터(body)를 설명해주는 헤더(Header)도 만들어서 같이 보내주어야 한다.
        */
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        /*
            요청하기 위해 헤더(Header)와 데이터(body) 합치기

            Q. Header -> accessToken 존재
               Body -> 사용자 정보 존재
               이를 하나로 묶는 건가 ?

            Spring Framework 에서 제공해주는
            HttpEntity 클래스는 Header 와 Body 를 합쳐준다.

            ★ 그러나 우리는 현재 headers 만 넣은 듯 ?
         */
        HttpEntity<Void> request = new HttpEntity<>(headers);

        /*
            POST 요청해보기

            RestTemplate 는 HTTP 메소드에 의한 평범한 기능 템플릿을 제공해주고,
            더 나아가 특병한 케이스를 지원하는  exchange 와 execute 메서드를 제공해준다.

            exchange() : 모든 HTTP 요청 메소드를 지원하며 원하는 서버에 요청시켜주는 메소드
         */
        GithubOauthAccountInfoResponse response = restTemplate.exchange(
                REQUEST_GITHUB_USER_API_URL, // 요청할 서버 주소
                HttpMethod.GET, // 요청할 방식
                request, // 요청할 때 보낼 데이터 (accessToken)
                GithubOauthAccountInfoResponse.class).getBody(); // 요청시 반환된는 데이터 타입

        log.info("result: " + response);

        // response 에 서버에서 응답해준 데이터가 저장될 것이다.
        return response;
    }

}
