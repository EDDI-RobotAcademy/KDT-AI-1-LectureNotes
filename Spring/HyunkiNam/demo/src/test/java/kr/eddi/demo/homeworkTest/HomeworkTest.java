package kr.eddi.demo.homeworkTest;

import kr.eddi.demo.lectureClass.testCode.member.entity.TestMember;
import kr.eddi.demo.lectureClass.testCode.member.repository.TestMemberRepository;
import kr.eddi.demo.lectureClass.testCode.member.service.TestMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeworkTest {

    @Autowired
    private TestMemberService testMemberService;

    @Autowired
    private TestMemberRepository testMemberRepository;

    @Test
    @DisplayName("Spring JUnit Test")
    void MemberTest(){
        final String expected_Name = "testing";
        final String expected_Password = "test";

        TestMember testMember = new TestMember(expected_Name, expected_Password);
        testMemberService.register(testMember);

        Optional<TestMember> maybeTestMember= testMemberRepository.findByMemberName(expected_Name);

        if(maybeTestMember.isEmpty()){
            System.out.println("회원 정보 없음");
        }

        testMember = maybeTestMember.get();
        final String actual_Name = testMember.getMemberName();
        final String actual_Password = testMember.getMemberPassword();

        assertEquals(expected_Name, actual_Name);
        assertEquals(expected_Password, actual_Password);
    }
}
