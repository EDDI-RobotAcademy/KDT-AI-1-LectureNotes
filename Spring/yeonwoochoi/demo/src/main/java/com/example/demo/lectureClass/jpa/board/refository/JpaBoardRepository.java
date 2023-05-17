package com.example.demo.lectureClass.jpa.board.refository;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository 데이터베이스에 저장
public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}
