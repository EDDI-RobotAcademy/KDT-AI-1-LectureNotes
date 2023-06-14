package com.example.demo.problem10.repository;

import com.example.demo.problem10.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
