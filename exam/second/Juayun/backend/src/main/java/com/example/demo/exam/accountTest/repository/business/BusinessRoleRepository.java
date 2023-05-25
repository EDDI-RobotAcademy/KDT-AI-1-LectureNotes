package com.example.demo.exam.accountTest.repository.business;

import com.example.demo.exam.accountTest.entity.business.BusinessAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRoleRepository extends JpaRepository<BusinessAccountRole, Long> {
}
