package com.example.demo.practice.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class BoardEntity {

    @Id
    private Long boardId;

    @Setter
    private String title;
    @Setter
    private String content;
    private String writer;

    public BoardEntity(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @CreatedDate
    private LocalDate createdDate;

    @UpdateTimestamp
    private LocalDate updatedDate;
}
