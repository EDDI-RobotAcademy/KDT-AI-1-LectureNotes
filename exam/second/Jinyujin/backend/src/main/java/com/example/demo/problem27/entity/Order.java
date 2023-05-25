package com.example.demo.problem27.entity;

import com.example.demo.problem10.entity.Member;
import com.example.demo.problem21.entity.ProductExam;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private ProductExam product;

    public Order(Member member, ProductExam product) {
        this.member = member;
        this.product = product;
    }
}
