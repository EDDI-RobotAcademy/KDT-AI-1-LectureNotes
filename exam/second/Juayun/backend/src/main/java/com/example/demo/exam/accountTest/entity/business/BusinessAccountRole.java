package com.example.demo.exam.accountTest.entity.business;

import com.example.demo.exam.accountTest.entity.Role;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class BusinessAccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessAccount")
    private BusinessAccount businessAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public BusinessAccountRole(BusinessAccount businessAccount, Role role) {
        this.businessAccount = businessAccount;
        this.role = role;
    }

}
