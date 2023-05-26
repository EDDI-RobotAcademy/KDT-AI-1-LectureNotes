package kr.eddi.demo.lectureClass.fetchType.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class JpaAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    public JpaAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}