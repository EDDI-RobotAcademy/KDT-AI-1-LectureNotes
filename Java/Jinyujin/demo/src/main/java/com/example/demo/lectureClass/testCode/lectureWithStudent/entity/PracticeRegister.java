package com.example.demo.lectureClass.testCode.lectureWithStudent.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PracticeRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PracticeStudent student;

    @ManyToOne(fetch = FetchType.LAZY)
    private PracticeLecture lecture;

    public PracticeRegister(PracticeStudent student, PracticeLecture lecture) {
        this.student = student;
        this.lecture = lecture;
    }
}
