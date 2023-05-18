package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity.TestPracticeAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestPracticeAccountRequestForm {

    final private String email;
    final private Integer password;
    final private String accountRole;

    public TestPracticeAccount toTestPractice() {
        return new TestPracticeAccount(email, password, accountRole);
    }
}
