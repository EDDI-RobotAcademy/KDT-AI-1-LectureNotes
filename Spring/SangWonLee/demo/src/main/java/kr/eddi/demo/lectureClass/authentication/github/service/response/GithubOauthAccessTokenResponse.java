package kr.eddi.demo.lectureClass.authentication.github.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GithubOauthAccessTokenResponse {
    // @JsonProperty 어노테이션은 Jackson 라이브러리에서 제공하며,
    // JSON 데이터와 Java 객체 간의 매핑을 제어하는데 사용된다.
    @JsonProperty("access_token")
    private String accessToken;
}