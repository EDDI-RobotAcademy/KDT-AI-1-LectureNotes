package kr.eddi.demo.problem1319.Account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class BusinessAccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @Getter
    @ManyToOne
    private Account account;
    private Integer businessCode;

    public BusinessAccountRole(String role, Integer businessCode, Account account) {
        this.role = role;
        this.account = account;
        this.businessCode = businessCode;
    }
}
