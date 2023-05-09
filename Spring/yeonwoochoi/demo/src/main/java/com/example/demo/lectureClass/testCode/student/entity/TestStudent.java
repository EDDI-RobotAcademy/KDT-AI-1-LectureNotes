package com.example.demo.lectureClass.testCode.student.entity;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
public class TestStudent {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Setter
    // 데이터베이스와 객체를 맵핑하기 위해 사용
    @ManyToOne
    // 왜래키를 맵핑할 때 사용
    @JoinColumn(name = "lecture_id")
    private TestLecture testLecture;

    public TestStudent(String name) {
        this.name = name;
    }
}