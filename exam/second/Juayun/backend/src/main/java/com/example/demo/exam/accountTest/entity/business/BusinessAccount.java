package com.example.demo.exam.accountTest.entity.business;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class BusinessAccount {

    @Id
    @Column(name = "business_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Integer businessCode;

    @OneToOne(mappedBy = "businessAccount", fetch = FetchType.LAZY)
    private BusinessAccountRole businessAccountRole;

    public BusinessAccount(String email, String password, Integer businessCode) {
        this.email = email;
        this.password = password;
        this.businessCode = businessCode;
    }

    public void setBusinessRole(BusinessAccountRole businessAccountRole) {
        this.businessAccountRole = businessAccountRole;

        businessAccountRole.setBusinessAccount(this);
    }
}
