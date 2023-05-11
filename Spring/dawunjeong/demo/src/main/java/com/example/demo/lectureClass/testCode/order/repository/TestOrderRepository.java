package com.example.demo.lectureClass.testCode.order.repository;

import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    // select * from 엔티티 이름
    // where는 조건
    // 파라미터(입력)은 ':id'
    // 특수문자 이상한데 붙이면 동작 안함
    @Query("select to from TestOrder to where to.testAccount.id = :id")
    List<TestOrder> findAllByAccountId(Long id);

    // 특정 상품을 구매한 회원 찾기(정다운)
    @Query("select to from TestOrder to where to.testProduct.Id = :id")
    List<TestOrder> findAllByProductId(Long id);

    // 특정 상품을 구매한 회원 찾기(선생님 풀이)
    @Query("select to from TestOrder to where to.testProduct.id = :productId")
    List<TestOrder> findAllAccountWhoBuyProduct(Long productId);
}
