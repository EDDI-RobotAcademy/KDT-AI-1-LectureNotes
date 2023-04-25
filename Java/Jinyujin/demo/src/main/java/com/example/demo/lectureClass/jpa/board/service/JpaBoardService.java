package com.example.demo.lectureClass.jpa.board.service;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {
    List<JpaBoard> list();
    // list의 구현체를 만들어줘야 함 Impl

    JpaBoard register(JpaBoard jpaBoard);
}
