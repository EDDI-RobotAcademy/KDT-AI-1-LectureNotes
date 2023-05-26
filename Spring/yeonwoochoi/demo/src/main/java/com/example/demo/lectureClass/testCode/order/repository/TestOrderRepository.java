package com.example.demo.lectureClass.testCode.order.repository;

import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    // select * from 엔티티이름 == select to from TestOrder to
    // where은 조건
    // 파라미터(입력)은 ':id'
    // 특수문자 이상한데 붙이면 동작 안함
    // (TestOrder에 Account 정보가 있고, Account에는 Id가 있음)
    @Query("select to from TestOrder to where to.testAccount.id = :id")
    List<TestOrder> findAllByAccountId( @Param("id") Long id);

    @Query("select to from TestOrder to where to.testProduct.id = :productId")
    List<TestOrder> findAllAccountWhoBuyProduct(@Param("productId") Long productId);
}
