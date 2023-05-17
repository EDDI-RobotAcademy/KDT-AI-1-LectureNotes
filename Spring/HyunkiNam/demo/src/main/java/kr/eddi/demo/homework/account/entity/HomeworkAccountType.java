package kr.eddi.demo.homework.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class HomeworkAccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private HomeworkAccount account;

    @ManyToOne
    private HomeworkAccountRole accountRole;

    public HomeworkAccountType(HomeworkAccount account, HomeworkAccountRole accountRole) {
        this.account = account;
        this.accountRole = accountRole;
    }
}