package com.example.demo.lectureClass.testCode.order.repository;

import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    // select * from 엔티티이름
    // where ~ 는 조건, 같다면 가져오고 같지않다면 없음
    // 파라미터(입력)은 ':id'
    // 특수문자 이상한데 붙이면 동작 안함

    @Query("select to from TestOrder to where to.testAccount.id = :id")
            // tesAccount 이름을 맞춰줘야함 entity
    List<TestOrder> findAllByAccountId(@Param("id") Long id);

    @Query("select to from TestOrder to where to.testProduct.id = :productId")
    List<TestOrder> findAllAccountWhoBuyProduct(@Param("productId") Long productId);

    // InvalidDataAccessApiUsageException 에러가 발생하면 query 에 의한 오류이기 때문에
    // param 을 붙이면 간단히 해결 가능하다

    // 내가 한 것
    // List<TestAccountResponseForm> findByProductId(Long id);

}
