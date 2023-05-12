package com.example.demo.lectureClass.fetchType.account.rpository;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole,Long> {
}
