package kr.eddi.demo.lectureClass.vue.problem4.controller;

import kr.eddi.demo.lectureClass.vue.problem4.controller.form.GameSignUpForm;
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
    private List<Member> memberList = new ArrayList<>();
    // 리스트에 넣어 줄 회원 숫자
    private Long memberUniqueNum = 0L;

    @PostMapping("/signUp")
    public Boolean gameSignUp (@RequestBody GameSignUpForm gameSignUpForm){
        log.info("gameSignUp()");

        checkedUserSignUp(gameSignUpForm);

        return true;
    }

    private Boolean checkedUserSignUp(GameSignUpForm gameSignUpForm) {
        log.info("checkedUserSignUp()");

        // 입력으로 들어온 아이디와 비밀번호가 존재하는지 안하는지 확인하기
        for(int i = 0; i < memberList.size(); i++){
            if(!memberList.get(i).getUniqueId().equals(gameSignUpForm.getUserId())){
                if(!memberList.get(i).getUniquePw().equals(gameSignUpForm.getUserPw())){
                    // 아이디와 비밀번호가 존재하지 않는다면 리스트에 추가해주기
                    memberList.add(gameSignUpForm.memberListAddInfo(memberUniqueNum++));
                    return true;
                }
            }
        }

        return false;
    }


}