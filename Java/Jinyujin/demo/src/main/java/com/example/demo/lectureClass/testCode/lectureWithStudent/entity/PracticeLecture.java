package com.example.demo.lectureClass.testCode.lectureWithStudent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PracticeLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    // many 쪽에 ManyToOne 달아줘야 함
    @ManyToOne
    private PracticeStudent student;

    public PracticeLecture(String name, PracticeStudent student) {
        this.name = name;
        this.student = student;
    }
    // student도 같이 넣어줘야 하나?
    // 웅 안넣으니까 테이블에 student_id가 null값으로 뜨네
}
