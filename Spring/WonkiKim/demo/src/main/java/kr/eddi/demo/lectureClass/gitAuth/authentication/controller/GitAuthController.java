package kr.eddi.demo.lectureClass.gitAuth.authentication.controller;

import kr.eddi.demo.lectureClass.gitAuth.authentication.service.GitOauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class GitAuthController {
    final private GitOauthService gitOauthService;

    @GetMapping("/github/login")
    public String requestGithubAuthorizeCode() {
        return gitOauthService.getAuthorizeCode();
    }
}
