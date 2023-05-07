package kr.jinho.jinhokim.practice.repository;

import kr.jinho.jinhokim.practice.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}
