package kr.eddi.demo.lectureClass.homework.vueVuetifySpringJPARedisBacklogAWS.problemAccount.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "problemRoleType")
@NoArgsConstructor
public class ProblemRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProblemRoleType roleType;

    public ProblemRole(ProblemRoleType roleType) {
        this.roleType = roleType;
    }

    public ProblemRoleType getRoleType () {
        return roleType;
    }
}
