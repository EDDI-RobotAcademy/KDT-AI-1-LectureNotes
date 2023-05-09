package kr.eddi.demo.memberTest;

import kr.eddi.demo.lectureClass.testCode.member.entity.TestMember;
import kr.eddi.demo.lectureClass.testCode.member.service.TestMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private TestMemberService testMemberService;

    @Test
    @DisplayName("회원이 존재하는지 확인 후 회원가입하기")
    void memberRegister () {
        // test 용으로 zisoo 를 입력받았다고 가정하고, 존재하는 지 확인하기
        TestMember testMember = new TestMember("zisoo");
        testMember = testMemberService.register(testMember);

        if(testMember == null){
            System.out.println("같은 아이디가 존재하므로 생성되지 않습니다.");
            return;
        }

        System.out.println("같은 아이디가 존재하지 않으므로 회원가입되었습니다!");
    }
}
