package kr.eddi.demo.lectureClass.fetchType.account.entity;


import jakarta.persistence.*;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@NoArgsConstructor
public class JpaAccountRole {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private JpaAccount jpaAccount;

    public JpaAccountRole(String role, JpaAccount jpaAccount) {
        this.role = role;
        this.jpaAccount = jpaAccount;
    }

}