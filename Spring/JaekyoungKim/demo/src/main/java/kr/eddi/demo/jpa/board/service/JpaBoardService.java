package kr.eddi.demo.jpa.board.service;



import kr.eddi.demo.jpa.board.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {
    List<JpaBoard> list();

    JpaBoard register(JpaBoard jpaBoard);
}