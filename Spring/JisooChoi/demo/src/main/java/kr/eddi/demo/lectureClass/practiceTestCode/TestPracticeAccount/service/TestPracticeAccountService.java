package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.service;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form.TestPracticeResponseForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity.TestPracticeAccount;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form.TestPracticeAccountRequestForm;

public interface TestPracticeAccountService {
    TestPracticeAccount register(TestPracticeAccountRequestForm requestForm);

    TestPracticeResponseForm login(TestPracticeAccountRequestForm requestForm);
}
