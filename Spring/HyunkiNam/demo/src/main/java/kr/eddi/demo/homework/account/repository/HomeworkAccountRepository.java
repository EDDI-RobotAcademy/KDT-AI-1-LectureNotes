package kr.eddi.demo.homework.account.repository;


import kr.eddi.demo.homework.account.entity.HomeworkAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeworkAccountRepository extends JpaRepository<HomeworkAccount, Long> {
}