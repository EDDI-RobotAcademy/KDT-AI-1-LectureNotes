package com.example.demo.exam.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class AccountBusiness {

    @Id
    @Column(name = "business_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String email;
    @Getter
    private String password;
    private Float BUSINESS_NUMBER;

    @OneToOne(mappedBy = "business", fetch = FetchType.LAZY)
    private AccountBusinessRole accountBusinessRole;

    public AccountBusiness(String email, String password, Float BUSINESS_NUMBER) {
        this.email = email;
        this.password = password;
        this.BUSINESS_NUMBER = BUSINESS_NUMBER;
    }

    public void setAccountBusinessRole(AccountBusinessRole accountBusinessRole) {
        this.accountBusinessRole = accountBusinessRole;

        accountBusinessRole.setBusiness(this);
    }
}
