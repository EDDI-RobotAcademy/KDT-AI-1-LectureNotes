package com.example.demo.controller.lectureClass.jpa.board.repository;

import com.example.demo.controller.lectureClass.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}
