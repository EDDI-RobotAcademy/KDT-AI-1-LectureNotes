package kr.jinho.jinhokim.testCode.order.entity;

import jakarta.persistence.*;
import kr.jinho.jinhokim.testCode.account.entity.TestAccount;
import kr.jinho.jinhokim.testCode.product.entity.TestProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TestOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Getter
    private TestAccount testAccount;

    @ManyToOne
    @Getter
    private TestProduct testProduct;

    public TestOrder(TestAccount testAccount, TestProduct testProduct) {
        this.testAccount = testAccount;
        this.testProduct = testProduct;
    }
}
