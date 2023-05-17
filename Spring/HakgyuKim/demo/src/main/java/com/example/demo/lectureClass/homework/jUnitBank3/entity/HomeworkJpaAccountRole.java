package com.example.demo.lectureClass.homework.jUnitBank3.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class HomeworkJpaAccountRole {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private HomeworkJpaRole homeworkJpaRole;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private HomeworkJpaAccount account;

    public HomeworkJpaAccountRole(HomeworkJpaAccount account, HomeworkJpaRole homeworkJpaRole) {
        this.homeworkJpaRole = homeworkJpaRole;
        this.account = account;
    }
}

