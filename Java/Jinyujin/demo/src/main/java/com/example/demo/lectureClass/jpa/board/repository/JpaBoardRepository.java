package com.example.demo.lectureClass.jpa.board.repository;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
    // DB 자체에 액세스하는 것은 repository가 함
    // repository에 대한 의존성(상속)은 스프링이 구동되면서 자동으로 붙음

    // 즉, 외부에서 요청이 들어오면 Controller에서 데이터를 받아서 Service에서 요청을 처리해주고
    // Repository로 가서 DB에 액세스 해준 후 다시 Service로 가서 return한 후
    // Controller가 처리된 데이터를 return해준다
    // 그 return한 결과는 Front로 전달됨
}
