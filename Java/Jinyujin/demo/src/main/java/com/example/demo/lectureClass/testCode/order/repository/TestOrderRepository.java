package com.example.demo.lectureClass.testCode.order.repository;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    @Query("select to from TestOrder to where to.testAccount.id = :id")
    List<TestOrder> findAllByAccountId(Long id);

    @Query("select to from TestOrder to where to.testProduct.id = :id")
    List<TestOrder> findAllAccountWhoBuyProduct(Long id);

    /*
        findAllByAccountId
        JPQuery? 해야 한다고 하심
        @Query 하고 오더에서 testAccount로 만들었으니 testAccount.id로 찾아주니 인식함
        그리고 돌리면 size: 2(테스트 출력문) -> 어제 등록한 상품만큼

        실제 sql에서는 이게 불가능
        select * from 엔티티이름 까지는 똑같고
        where는 조건 testOrder에 testAccount 있고 거기에 id가 있음
        그 id값이 testAccount의 id와 같냐
        같으면 땡겨와라
        where는 조건
        파라미터(입력)은 ':id'
        특수문자 이상한데 붙이면 동작안함
     */

    /*
        findAllAccountWhoBuyProduct
        productId로 찾으면 impl의 orderList에 들어갈 것
     */
}
