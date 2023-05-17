package kr.eddi.demo.homework.account.repository;

import kr.eddi.demo.homework.account.entity.HomeworkAccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkAccountTypeRepository extends JpaRepository<HomeworkAccountType, Long> {
}
