package kr.eddi.demo.authentication.github.service.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GithubOauthAccessTokenResponse {

    @JsonProperty("access_token")
    private String accessToken;
}
