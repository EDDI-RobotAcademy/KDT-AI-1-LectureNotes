package com.example.demo.problem10.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public MemberRole(Role role, Member member) {
        this.role = role;
        this.member = member;
    }
}
