package com.example.demo.lectureClass.jpa.board.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
// Entity 설정 -> Jpa가 관리하는 클래스
@ToString
@Getter
@NoArgsConstructor
// Entity 어노테이션이 붙으면 기본 생성자가 필수이기에 추가해줘야 함
// why? Jpa가 Entity 객체 생성 시 기본 생성자를 사용하기 때문
@EqualsAndHashCode
public class JpaBoard {
    // JpaBoard라는 Entity를 만들어줌

    // 얘들의 각각의 목적이 뭘까?
    @Id
    // 고유값 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본키 값에 대한 생성 전략
    private Long boardId;
    // boardId의 존재 이유는?
    // 유일성 + 구분해주기 위해서
    // 예전에 CustomSequence로 하나씩 올라가게 해줬는데 그 역할을 위 3줄이 하게 되는 것
    // (기억 안나니 한 번 더 보자!)

    // JpaBoard를 구성할 것들 선언 - 제목, 작성자, 내용
    @Setter
    private String title;
    private String writer;

    @Setter
    private String content;
    // 결국 위 3개가 사용자가 관리하는 주 목적
    // setter는 딱 필요한 애들한테만 설정

    public JpaBoard(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    // pattern: 원하는 날짜 형식을 지정
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updateDate;
    // 날짜 두 줄은 자동으로 생성된다고 함
}
