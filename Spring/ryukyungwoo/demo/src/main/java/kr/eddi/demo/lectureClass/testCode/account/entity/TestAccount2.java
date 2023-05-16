package kr.eddi.demo.lectureClass.testCode.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Entity
public class TestAccount2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Getter
    final private String eMail;
    @Getter
    final private String password;

    public TestAccount2(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }
}
