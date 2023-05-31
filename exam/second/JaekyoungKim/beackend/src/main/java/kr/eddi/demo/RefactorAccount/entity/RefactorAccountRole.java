package kr.eddi.demo.RefactorAccount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class RefactorAccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private RefactorAccount account;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "role_id")
    private RefactorRole role;

    public RefactorAccountRole(RefactorAccount account, RefactorRole role) {
        this.account = account;
        this.role = role;
    }
}
