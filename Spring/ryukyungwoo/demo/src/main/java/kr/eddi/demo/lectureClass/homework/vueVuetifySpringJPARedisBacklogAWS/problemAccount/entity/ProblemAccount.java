package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ProblemAccount {
    @Id
    @Column(name = "problem_account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProblemAccountRole accountRole;

    public ProblemAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(ProblemAccountRole accountRole) {
        this.accountRole = accountRole;

        accountRole.setAccount(this);
    }
}
