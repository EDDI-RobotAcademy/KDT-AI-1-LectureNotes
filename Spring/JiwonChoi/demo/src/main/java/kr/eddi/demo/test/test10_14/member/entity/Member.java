package kr.eddi.demo.test.test10_14.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String password;
    private String memberNumber;

    public Member(String email, String password, String memberNumber) {
        this.email = email;
        this.password = password;
        this.memberNumber = memberNumber;
    }
}
