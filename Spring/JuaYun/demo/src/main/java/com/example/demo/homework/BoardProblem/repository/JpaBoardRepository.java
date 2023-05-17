package com.example.demo.homework.BoardProblem.repository;

import com.example.demo.homework.BoardProblem.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
    // JpaBoardRepository 는 Spring Framework 에서 제공하는
    // spring Data JPA 모듈에서 제공하는 인터페이스 중 하나이다.
    // 인터페이스를 상속받는 클래스는 JpaRepository<Entity 클래스, PK 타입>을 상속받음으로써
    // 기본적인 CRUD(Create, Read, Update, Delete)기능을 사용할 수 있다.
    // 이 때 Entity 클래스는 데이터베이스에서 사용하는 테이블과 맵핑되는 클래스이다.
    // PK 타입은 Entity 클래스의 ID 필드의 타입과 일치해야 한다.
    // JpaRepository 인터페이스를 상속받는 인터페이스나 클래스에서는
    // JpaRepository 인터페이스의 메소드를 그대로 상속받아 사용할 수 있다.
    // JpaRepository 인터페이스에서는 save, delete, findById, findAll 등의 메소드를 제공한다.
}
