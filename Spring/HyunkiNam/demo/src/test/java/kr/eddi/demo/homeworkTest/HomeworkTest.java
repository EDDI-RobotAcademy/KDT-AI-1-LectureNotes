package kr.eddi.demo.homeworkTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeworkTest {

    private TestMemberService testMemberService;
    private TestMemberRepository testMemberRepository;

    @Test
    @DisplayName("Spring JUnit Test")
    void MemberTest(){
        final String expected_Id = "testing";
        final String expected_Password = "test";

        TestMember testMember = new TestMember(expected_Id, expected_Password);
        testMemberService.register(testMember);

        Optional<TestMember> maybeTestMember= testMemberRepository.findByMemberId(expected_Id);

        if(maybeTestMember.isEmpty()){
            System.out.println("회원 정보 없음");
        }

        testMember = maybeTestMember.get();
        assertEquals(expected_Id, testMember.getMemberId());
        assertEquals(expected_Password, testMember.getMemberPassword());
    }
}
