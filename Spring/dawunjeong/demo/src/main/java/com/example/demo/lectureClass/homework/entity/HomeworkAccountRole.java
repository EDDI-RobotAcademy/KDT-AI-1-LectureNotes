package com.example.demo.lectureClass.homework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class HomeworkAccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private HomeworkAccount homeworkAccount;

    @ManyToOne
    private Role role;

    public HomeworkAccountRole(HomeworkAccount homeworkAccount, Role role) {
        this.homeworkAccount = homeworkAccount;
        this.role = role;
    }
}
