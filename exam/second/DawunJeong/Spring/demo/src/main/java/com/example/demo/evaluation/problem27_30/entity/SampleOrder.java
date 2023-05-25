package com.example.demo.evaluation.problem27_30.entity;

import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem21_26.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class SampleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Getter
    private Account account;

    @ManyToOne
    @Getter
    private Product product;

    public SampleOrder(Account account, Product product) {
        this.account = account;
        this.product = product;
    }
}
