package com.example.demo.problem.order.entity;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.product.entity.Product;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = { "product", "account" })
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Orders(Product product, Account account) {
        this.product = product;
        this.account = account;
    }
}
