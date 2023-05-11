package com.example.demo.lectureClass.testCode.lecture.entity;

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

    @Getter
    private String lectureName;

    public TestLecture(String lectureName) {
        this.lectureName = lectureName;
    }
}
