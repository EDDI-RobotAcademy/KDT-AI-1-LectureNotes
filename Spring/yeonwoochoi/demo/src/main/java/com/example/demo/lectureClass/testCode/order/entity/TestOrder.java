package com.example.demo.lectureClass.testCode.order.entity;

import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne
    private TestAccount testAccount;

    @Getter
    @ManyToOne
    private TestProduct testProduct;

    public TestOrder(TestAccount testAccount, TestProduct testProduct) {
        this.testAccount = testAccount;
        this.testProduct = testProduct;
    }
}
