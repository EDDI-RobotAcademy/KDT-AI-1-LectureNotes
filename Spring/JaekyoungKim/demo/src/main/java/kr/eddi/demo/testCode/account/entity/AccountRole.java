package kr.eddi.demo.testCode.account.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    @Getter
    @ManyToOne
    private TestAccount account;

    public AccountRole(String role, TestAccount account) {
        this.role = role;
        this.account = account;
    }
}