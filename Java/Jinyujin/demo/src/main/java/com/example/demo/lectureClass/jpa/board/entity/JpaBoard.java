package com.example.demo.lectureClass.jpa.board.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class JpaBoard {
    // 얘들의 각각의 목적이 뭘까?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    // boardId의 존재 이유는?
    // 유일성 + 구분해주기 위해서
    // 예전에 Custom Sequence로 하나씩 올라가게, map으로 해줬는데 그 역할을 위 3줄이 하게 되는 것
    // (기억 안나니 한 번 더 보자!)

    @Setter
    private String title;
    private String writer;

    @Setter
    private String content;
    // 결국 위 3개가 사용자가 관리하는 주 목적

    public JpaBoard(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updateDate;
    // 날짜 두 줄은 자동으로 생성된다고 함
}
