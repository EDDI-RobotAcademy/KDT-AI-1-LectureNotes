package com.example.demo.lectureClass.testCode.lecture.entity;

import com.example.demo.lectureClass.testCode.student.entity.TestStudent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TestLecture {

    @Id
    @Column(name = "lecture_id")
    // TestStudent와 같이 쓰기에 필요한 어노테이션 - 기본키
    // lecture_id가 TestStudent에서 외래키가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;
    // @Column(name = "lecture_id")
    // MySql 워크벤치에서 테이블을 확인해보면 lectureId라고 적으면 lecture_id라고 뜨고
    // 아래 lectureName은 테이블에서 lecture_name으로 뜸
    // 그래서 한 회원이 상품 주문하는 테스트에서 나는 구분하려고 accountId, productId, orderId
    // 이렇게 작성했는데 getter를 통해서 accountId와 productId를 가져오니까
    // account_account_id, product_product_id 이렇게 나타남

    @Getter
    private String lectureName;

    public TestLecture(String lectureName) {
        this.lectureName = lectureName;
    }
}
