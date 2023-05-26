package kr.jinho.jinhokim.testCode.order.repository;

import kr.jinho.jinhokim.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {

    @Query("select to from TestOrder to where to.testAccount.id = :id")
    List<TestOrder> findAllByAccountId(@Param("id") Long id);

    @Query("select to from TestOrder to where to.testProduct.id = :productId")
    List<TestOrder> findAllAccountWhoBuyProduct(Long productId);
}
