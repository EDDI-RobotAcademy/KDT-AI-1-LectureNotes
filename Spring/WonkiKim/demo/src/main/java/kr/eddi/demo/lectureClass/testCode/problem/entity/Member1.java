package kr.eddi.demo.lectureClass.testCode.problem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String accountId;
    private String password;

    public Member1(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
