package kr.eddi.demo.lectureClass.vue.problem4.controller;

import kr.eddi.demo.lectureClass.vue.problem4.controller.form.GameSignInForm;
import kr.eddi.demo.lectureClass.vue.problem4.controller.form.GameSignUpForm;
import kr.eddi.demo.lectureClass.vue.problem4.game.Account;
import kr.eddi.demo.lectureClass.vue.problem4.game.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/game-world")
public class VueProblem4Controller {

    // 회원가입 하는 사람들의 정보를 넣을 리스트
    private static List<Member> memberList = new ArrayList<>();
    // 리스트에 넣어 줄 회원 숫자
    private static Long memberUniqueNum = 0L;

    @PostMapping("/signUp")
    public Boolean gameSignUp (@RequestBody GameSignUpForm gameSignUpForm){
        log.info("gameSignUp()");

        // 사용자가 입력한 아이디와 비밀번호의 정보를 가진 member 객체 생성
        Member member = gameSignUpForm.memberListAddInfo(memberUniqueNum++);

        // 사용자가 입력한 아이디가 리스트에 존재하는 가?
        for(int i = 0; i < memberList.size(); i++){
            if(member.getUniqueId().equals(memberList.get(i).getUniqueId())){
                log.info("동일한 아이디가 존재합니다.");
                return true;
            }
        }
        memberList.add(member);
        log.info("새로운 계정이 생성됩니다.");
        return false;
    }

    @PostMapping("/signIn")
    public Account gameSignIn(@RequestBody GameSignInForm gameSignInForm){
        log.info("gameSignIn() ");

        Account account = gameSignInForm.dataAgreementStep(false);

        // 들어오는 아이디 비밀번호 값이 리스트에 존재하는 지 확인
        for(int i = 0; i < memberList.size(); i++){
            if(account.getAccountId().equals(memberList.get(i).getUniqueId())){
                if(account.getAccountPw().equals(memberList.get(i).getUniquePw())){
                    // 아이디와 패스워드가 리스트에 존재한다면 로그인 완료 !
                    account.setExistAccount(true);
                    return account;
                }
            }
        }
        return account;
    }

}