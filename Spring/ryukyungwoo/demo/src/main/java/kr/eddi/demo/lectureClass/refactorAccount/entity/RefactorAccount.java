package kr.eddi.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class RefactorAccount {

    @Id
    @Column(name = "refactor_account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private RefactorAccountRole refactorAccountRole;

    public RefactorAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(RefactorAccountRole accountRole) {
        this.refactorAccountRole = accountRole;

        accountRole.setAccount(this);
    }
}
