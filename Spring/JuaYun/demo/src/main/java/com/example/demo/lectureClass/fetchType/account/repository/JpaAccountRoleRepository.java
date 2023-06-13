package com.example.demo.lectureClass.fetchType.account.repository;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {

    // JpaAccountRole ar = new JpaAccountRole();
    // ar.role 은 실제로 Java 문법상 가능한 표현
    // 실제 DB Query 에서 이와 같은 문법이 불가능하지만
    // JPA 를 사용함으로써 실제 DB Query 를 class 이름과 class 내부의 필드(변수) 로 대체할 수 있음
    @Query("select ar from JpaAccountRole ar join fetch ar.account ja where ar.role = :role")
    List<JpaAccountRole> findAllByRole(@Param("role") String role);
    // Lazy 를 활성화 시키는 키워드 join fetch
    // ar.account entity 에서 설정한 이름과 맞춰줘야한다.
}
