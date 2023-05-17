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
    @ManyToOne //과목을 듣는 학생은 여럿
    @JoinColumn(name = "lecture_id")
    private TestLecture testLecture;

    public TestStudent(String name){
        this.name =name;
    }
}
