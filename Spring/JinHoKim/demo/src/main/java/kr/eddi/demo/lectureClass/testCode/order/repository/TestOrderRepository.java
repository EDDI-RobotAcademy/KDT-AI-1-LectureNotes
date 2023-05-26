package kr.eddi.demo.lectureClass.testCode.order.repository;

import kr.eddi.demo.lectureClass.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    // select * from 엔티티이름
    // where 은 조건
    // 파라미터(입력)은 ':id'
    // 특수문자 이상한데 붙이면 동작 안함
    // @Query 는 Spring Data JPA 에서 사용되는 어노테이션입니다.
    // 이 어노테이션을 사용하면 JPA 쿼리 언어인 JPQL(Java Persistence Query Language) 또는
    // 네이티브 SQL 쿼리를 사용하여 데이터베이스에서 데이터를 검색할 수 있습니다.
    @Query("select to from TestOrder to where to.testAccount.id = :id")
    List<TestOrder> findAllByAccountId(Long id);

    //즉, 이 코드는 TestOrder 엔티티의 testAccount 속성에서
    // id 값이 Long 타입의 id 매개 변수와 일치하는 모든 TestOrder 엔티티를 검색하고,
    // 이를 List<TestOrder> 타입으로 반환합니다.
    // 이 코드는 findAllByAccountId 라는 메소드 이름을 가진 Spring Data JPA 리포지토리 메소드로 사용됩니다.


    @Query("select to from TestOrder to where to.testProduct.id = :productId")
    List<TestOrder> findAllAccountWhoBuyProduct(Long productId);
}