package kr.eddi.demo.lectureClass.testCode.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Getter
    @ManyToOne //one : many 일때 many쪽 필드에 적어준다
    private TestAccount account;

    public AccountRole(String role, TestAccount account) {
        this.role = role;
        this.account = account;
    }
}