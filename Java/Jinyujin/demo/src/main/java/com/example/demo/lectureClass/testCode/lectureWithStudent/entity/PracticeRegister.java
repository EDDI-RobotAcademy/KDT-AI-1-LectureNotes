package com.example.demo.lectureClass.testCode.lectureWithStudent.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PracticeRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PracticeStudent student;

    @ManyToOne
    private PracticeLecture lecture;

    public PracticeRegister(PracticeStudent student, PracticeLecture lecture) {
        this.student = student;
        this.lecture = lecture;
    }
}
