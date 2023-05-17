package kr.eddi.demo.lectureClass.testCode.problem.order.entity;

import jakarta.persistence.*;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne
    private Member member;
    @Getter
    @ManyToOne
    private Product product;

    public OrderEntity(Member member, Product product) {
        this.member = member;
        this.product = product;
    }
}
