package com.example.demo.practice.board.repository;

import com.example.demo.practice.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // JpaRepository로 정확하게 상속받아야 함
}
