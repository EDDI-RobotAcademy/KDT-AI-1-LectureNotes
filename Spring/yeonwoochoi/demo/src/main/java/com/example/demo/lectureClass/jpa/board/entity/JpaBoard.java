package com.example.demo.lectureClass.jpa.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor
// JpaBoard 게시물을 표현
// entity 핵심 업무 규칙 (이것 위주로 돌아가기 때문)
// 필요한 정보
// 외부 요청은 서버 (컨트롤러가 받는다.)
public class JpaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    // 세가지가 실제 사용자가 입력하는 것
    @Setter
    private String title;

    private String writer;

    // 수정은 setter가 필요하다.(title / content)
    @Setter
    private String content;

    public JpaBoard(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateFate; // 갱신될때 자동으로 들어간다.
}
