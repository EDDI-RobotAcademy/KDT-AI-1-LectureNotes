package com.example.demo.lectureClass.fetchType.account.repository;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaAccountRoleRepository extends JpaRepository<JpaAccountRole, Long> {
}
