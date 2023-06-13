package kr.eddi.demo.lectureClass.account.controller;

import kr.eddi.demo.lectureClass.account.controller.form.AccountRegisterForm;
import kr.eddi.demo.lectureClass.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class MemberAccountController {

    final private AccountService accountService;

    @GetMapping("/check-email/{email}")
    public Boolean checkEmail(@PathVariable("email") String email) {
        log.info("check email duplication: " + email);

        return accountService.checkEmailDuplication(email);
    }

    @PostMapping("/sign-up")
    public Boolean signUp(@RequestBody AccountRegisterForm form) {
        /*
            Q.
            form 으로 데이터를 받아왔는데,
            form.toAccountRegisterRequest()로 보내는 이유 ?

            -> A.
            Service 에서 최적화되지 않은 작업들은 Request 를 통해 제어가 가능하며,
            Request 는 Service 에 실질적인 요청을 한다.
            RequestForm 이 양식 이라면, Request 는 실질적인 요청인 것이다.
            그래서 Service 가 이 요청을 처리하는 구조로 구성한다.
        */
        log.info("signUp(): " + form);

        return accountService.signUp(form.toAccountRegisterRequest());
    }

//    @GetMapping("/github/login")
//    public void githubLoginCallback(HttpServletResponse response) {
//        response.sendRedirect("http://localhost:8080/");
//    }

}
