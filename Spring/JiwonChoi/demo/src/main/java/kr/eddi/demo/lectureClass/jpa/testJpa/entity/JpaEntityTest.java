package kr.eddi.demo.lectureClass.jpa.testJpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JpaEntityTest {
    //db에 들어가는게 이 클래스들..

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    private String title;
    private String content;
    private Integer testNumber;

}
