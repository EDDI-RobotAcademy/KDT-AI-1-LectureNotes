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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String name;

    @JoinColumn(name = "lecture_id")
    // 외래키 가져옴
    // lecture_id 이걸 참조
    @Setter
    @ManyToOne
    // 수강과목에 대한 학생 수는 많으니까
    private TestLecture lecture;

    public TestStudent(String name) {
        this.name = name;
    }
}
