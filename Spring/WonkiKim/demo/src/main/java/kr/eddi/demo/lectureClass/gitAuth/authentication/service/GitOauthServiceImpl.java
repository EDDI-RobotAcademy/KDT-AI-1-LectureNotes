package kr.eddi.demo.lectureClass.gitAuth.authentication.service;

import kr.eddi.demo.lectureClass.utility.PropertyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GitOauthServiceImpl implements GitOauthService{
    final private RestTemplate restTemplate;
    final private PropertyUtil propertyUtil;
    @Override
    public String getAuthorizeCode() {
        final String CID = propertyUtil.getProperty("cid");
        final String URL = "https://github.com/login/oauth/authorize";

        return URL + "?client_id=" + CID + "&scope=repo:status read:repo_hook user:email";;
    }
}
