package com.example.demo.lectureClass.homework.jUnitBank3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "homeworkJpaAccountRoleType")
@NoArgsConstructor
public class HomeworkJpaRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    private HomeworkJpaAccountRoleType roleType;

    public HomeworkJpaRole(HomeworkJpaAccountRoleType roleType) {
        this.roleType = roleType;
    }
}
