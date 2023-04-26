package com.example.demo.lectureClass.jpa.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class JpaBoard {

    // 고유 아이디 값 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;


    // 수정될 수 있는 곳에만 Setter 설정
    @Setter
    private String title;
    private String writer;

    @Setter
    private String content;

    public JpaBoard(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    // 작성 시간
    @CreationTimestamp
    private LocalDateTime createDate;

    // 업데이트(수정) 시간
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
