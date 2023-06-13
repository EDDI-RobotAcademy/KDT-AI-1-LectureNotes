package kr.eddi.demo.lectureClass.refactorAccount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roleType")
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Getter
    private RoleType roleType;

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }
}
