package com.example.demo.lectureClass.fetchType.account.repository;

import com.example.demo.lectureClass.fetchType.account.entity.RoleType;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {

//    @Query("select ar from JpaAccountRole ar join fetch JpaAccount ja where ar.role = :role")
    // 오류 -> JpaAccount가 아닌 JpaAccountRole안에 만들어놓은 JpaAccount 객체를 가져와줘야 하기 때문에 ar.account를 가져와줘야 함

    @Query("select ar from JpaAccountRole ar join fetch ar.account ja where ar.role = :role")
    List<JpaAccountRole> findAllByRole(String role);

    // join fetch를 하면 자빠져있는 애를 깨워서 일을 시킬 수 있음
    // 나는 JpaAccountRole 테이블만 필요한데 JpaAccount 테이블까지 다가져와버리는 것을 방지하기 위해서
    // 일단 JpaAccountRole에 있는 JpaAccount 객체에 Lazy를 붙여주어서 JpaAccount객체를 가져오는 것을 방지
    // 즉 JpaAccount 객체를 알맞는 조건만 가져오기 위해서 Lazy를 붙여주고
    // repository에서 쿼리를 붙여 알맞는 role만 가져오도록 하는 것

    // JpaAccountRole ar = new JpaAccountRole();
    // ar.role은 실제로 Java 문법상 가능한 표현
    // 실제 DB Query에서 이와 같은 문법이 불가능하지만
    // JPA를 사용함으로서 실제 DB Query를 class 이름과 class 내부의 필드(변수)로 대체할 수 있음
    /*
        select가 조건
        JpaAccountRole을 ar로 줄이고 JpaAccount를 ja로 줄여서 사용
        JpaAccount에서 email을 찾겠다 하면 ja.email을 찾아서 가져올 수도 있음

        JpaAccountRole ar 이 new JpaAccountRole과 같다는 것
        Jpa라서 가능하대
     */
}
