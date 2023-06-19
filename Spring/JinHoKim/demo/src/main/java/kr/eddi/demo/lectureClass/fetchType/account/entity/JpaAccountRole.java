package kr.eddi.demo.lectureClass.fetchType.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = {"account"})
@NoArgsConstructor
public class JpaAccountRole {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private JpaAccount account;

    public JpaAccountRole(String role, JpaAccount account) {
        this.role = role;
        this.account = account;
    }
}
