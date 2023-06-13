package com.example.demo.lectureClass.jpa.board.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;


@Entity
@Getter
@ToString
@NoArgsConstructor
public class JpaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;  // 게시물 번호

    @Setter // 수정 가능하다
    private String title;   // 게시물 제목
    private String writer;  // 게시물 작성자

    @Setter
    private String content;  // 게시물 내용

    public JpaBoard(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:MM", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime createDate;  // 등록일자

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:MM", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
