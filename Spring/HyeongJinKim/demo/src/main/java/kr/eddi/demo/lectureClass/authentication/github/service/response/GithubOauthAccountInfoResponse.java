package kr.eddi.demo.lectureClass.authentication.github.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GithubOauthAccountInfoResponse {

    @JsonProperty("id")
    public String id;

    @JsonProperty("login")
    public String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("html_url")
    private String githubRepository;

    @JsonProperty("public_repos")
    private Long publicRepositoryNumber;

}
