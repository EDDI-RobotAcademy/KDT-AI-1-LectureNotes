package kr.eddi.demo.lectureClass.fetchType.account.repository;

import kr.eddi.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {
    // JpaAccountRole ar = new JpaAccountRole();
    // ar.role 은 실제로 Java 문법상 가능한 표현
    // 실제 DB Query 에서 이와 같은 문법이 불가능하지만
    // JPA 를 사용함으로서 실제 DB Query 를 class 이름과 class 내부의 필드(변수)로 대체할 수 있음

    @Query("select ar from JpaAccountRole ar join fetch JpaAccount ja where ar.role = :role")
    List<JpaAccountRole> findAllByRole(String role);

    //해당 코드는 Spring Data JPA 에서 제공하는 `@Query` 어노테이션을 사용한 JPQL(QueryDSL) 쿼리문입니다.
    //
    //해당 쿼리문은 `JpaAccountRole`과 `JpaAccount` 엔티티를 조인하고,
    // `ar.role`이 파라미터 `role`과 일치하는 `JpaAccountRole` 엔티티를 조회합니다.
    // 또한 `join fetch` 구문을 사용하여 Eager Fetching 방식으로 연관된 엔티티(`JpaAccount`)도 함께 로딩합니다.
    //
    //즉, `JpaAccountRole`과 `JpaAccount` 엔티티 간의 다대일 관계에서,
    // `JpaAccountRole` 엔티티의 `role` 필드와 파라미터 `role`이 일치하는 레코드를 조회하면서,
    // `JpaAccount` 엔티티도 함께 로딩하는 쿼리문입니다.
}