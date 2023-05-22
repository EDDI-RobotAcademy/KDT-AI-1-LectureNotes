package com.example.demo.exam.accountTest.entity.account;

import com.example.demo.exam.accountTest.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class AccountRole {
    /*
        - AccountRole 클래스에는 Account 클래스와 Role 클래스를 가져옴
        - account 와 account_id / role 과 role_id 를 맵핑
        - 이건 mysql 에서 확인할 수 있음
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public AccountRole(Account account, Role role) {
        this.account = account;
        this.role = role;
    }
}
