package kr.eddi.demo.lectureClass.testCode.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // Entity 는 데이터베이스와 동일한 구조를 가지고 있다.
@Getter
@NoArgsConstructor
public class TestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public TestAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}