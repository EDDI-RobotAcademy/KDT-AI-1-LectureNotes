package kr.eddi.demo.homework.account.entity;


import jakarta.persistence.*;
import kr.eddi.demo.lectureClass.fetchType.account.entity.JpaAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accountType")
@NoArgsConstructor
public class HomeworkAccountRole {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    private HomeworkAccountRoleType accountRoleType;

    public HomeworkAccountRole(HomeworkAccountRoleType accountRoleType) {
        this.accountRoleType = accountRoleType;
    }

    public HomeworkAccountRoleType getAccountRoleType() {
        return accountRoleType;
    }
}