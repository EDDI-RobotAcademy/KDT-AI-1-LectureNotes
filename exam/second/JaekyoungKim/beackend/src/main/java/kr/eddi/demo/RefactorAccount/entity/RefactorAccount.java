package kr.eddi.demo.RefactorAccount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@NoArgsConstructor
public class RefactorAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private RefactorAccountRole accountRole;

    public RefactorAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(RefactorAccountRole accountRole) {
        this.accountRole = accountRole;
        accountRole.setAccount(this);
    }
}
