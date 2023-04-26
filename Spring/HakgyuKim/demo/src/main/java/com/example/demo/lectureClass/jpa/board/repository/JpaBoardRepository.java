package com.example.demo.lectureClass.jpa.board.repository;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
    // JpaRepository = DB에 JpaBoard를 고유 아이디값(long)을 key로 저장
    // extend 함으로서 .findById .deleteById 등 매서드 사용 가능
}
