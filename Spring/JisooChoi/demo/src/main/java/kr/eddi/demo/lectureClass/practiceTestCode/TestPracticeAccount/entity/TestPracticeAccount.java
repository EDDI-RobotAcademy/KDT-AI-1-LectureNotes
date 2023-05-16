package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TestPracticeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private Integer password;
    private String accountRole;

    public TestPracticeAccount(String email, Integer password, String accountRole) {
        this.email = email;
        this.password = password;
        this.accountRole = accountRole;
    }
}
