package kr.eddi.demo.lectureClass.authentication.github.service;
import kr.eddi.demo.lectureClass.authentication.github.service.request.GithubOauthTokenRequest;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccessTokenResponse;
import kr.eddi.demo.lectureClass.authentication.github.service.response.GithubOauthAccountInfoResponse;
import kr.eddi.demo.lectureClass.utility.property.PropertyUtil;
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
                "https://github.com/login/oauth/access_token";//문서에 있는 주소도 요청함
        final String CLIENT_ID = propertyUtil.getProperty("client_id"); //"yourGithubOAuthAppsId"; //id값
        final String CLIENT_SECRETS = propertyUtil.getProperty("client_secrets");//secrets값
        //property 때문에 CLIENT_ID,CLIENT_SECRETS를 비밀로 할 수 있음
        return restTemplate.postForObject(//postForObject => AccessToken을 달라는 요청을 해야함
                REQUEST_GITHUB_ACCESS_TOKEN_URL,//(~~code는 파라미터로 받은것)
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

