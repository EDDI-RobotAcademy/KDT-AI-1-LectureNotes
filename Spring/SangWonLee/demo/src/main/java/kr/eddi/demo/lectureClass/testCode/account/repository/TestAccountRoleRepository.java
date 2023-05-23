package kr.eddi.demo.lectureClass.testCode.account.repository;

import kr.eddi.demo.lectureClass.testCode.account.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestAccountRoleRepository extends JpaRepository<AccountRole, Long> {
    List<AccountRole> findAllByRole(String role);
    // role을 매개변수로 받아 AccountRole 객체의 리스트를 반환한다.
    // Spring Data JPA 쿼리 생성 규칙으로 인해 findAllByRole 이라 하면
    // 이 메소드를 쿼리 메소드로 인식하고 메소드를 실행한다.
    // findAllBy 이름은 role필드가 주어진 값과 일치하는
    // 모든 AccountRole 객체를 찾는 쿼리를 생성하도록 지시한다.
}