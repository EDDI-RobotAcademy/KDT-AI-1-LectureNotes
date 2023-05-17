package com.example.demo.lectureClass.fetchType.account.repository;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {
    // JpaAccountRole ar = new JpaAccountRole();
    // ar.role은 실제로 Java 문법상 가능한 표현
    // 실제 DB Query에서 이와 같은 문법이 불가능하지만
    // JPA를 사용함으로써 실제 DB Query를 class 이름과 class 내부의 필드(변수)로 대체할 수 있음
    // join fetch JpaAccount ja -> join fetch ar.account 으로 수정해야 함
    // JpaAccountRole의 JpaAccount를 가져와야 하므로 ar.account로 명시해줘야 함
    @Query("select ar from JpaAccountRole ar join fetch ar.account where ar.role = :role")
    List<JpaAccountRole> findAllByRole(String role);
}
