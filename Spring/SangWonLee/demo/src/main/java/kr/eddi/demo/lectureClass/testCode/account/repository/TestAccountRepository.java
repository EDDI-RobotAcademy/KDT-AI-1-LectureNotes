package kr.eddi.demo.lectureClass.testCode.account.repository;

import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestAccountRepository extends JpaRepository<TestAccount, Long> {
    Optional<TestAccount> findByEmail(String email);

//    findByEmail 메소드는 이메일 주소를 인자로 받아 해당 이메일 주소를 가진
//    TestAccount 객체를 찾아 반환합니다.
//    이 메소드는 Optional을 반환하므로 해당 이메일 주소를 가진
//    TestAccount 객체가 없으면 빈 Optional이 반환됩니다.
}