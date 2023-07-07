package kr.eddi.demo.authentication.github.service.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GithubOauthAccountInfoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("login")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("html_url")
    private String githubRepository;

    @JsonProperty("public_repos")
    private Long publicRepositoryNumber;
}