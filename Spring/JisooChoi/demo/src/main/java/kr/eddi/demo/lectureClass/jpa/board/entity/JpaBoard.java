package kr.eddi.demo.lectureClass.jpa.board.entity;

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

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class JpaBoard {
    // ※ 엔티티(=핵심 업무 규칙)가 중요하며, 현재 엔티티는 게시물을 나타내고 있다.
    // 도메인의 설정이 완료되었다고 할 수 있다.

    // CustomSequence 역할을 한다.
    // 각 배열에 값을 넣어줄 때, 1번째 2번째 ... 이렇게 넣는데
    // 넣을 때, 번째의 숫자는 점점 커져야 데이터를 저장할 수 있다. 뭐 이런 개념
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId; // 게시판 아이디 (유일성) -> 고유값

    // ※ setter가 열려있는 이유: 나중에 게시물 수정을 하기 위해
    @Setter
    private String title; // 제목
    private String writer; // 작성자

    @Setter
    private String content; // 내용

    public JpaBoard(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    // JsonFormat 은 날짜 형식을 바꾸어주기 위해 사용한다.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    // 아래는 디지털 포렌식 때문에 쓴다.
    @CreationTimestamp
    private LocalDateTime createDate; // 생성일자

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updateDate; // 업데이트 일자

}
