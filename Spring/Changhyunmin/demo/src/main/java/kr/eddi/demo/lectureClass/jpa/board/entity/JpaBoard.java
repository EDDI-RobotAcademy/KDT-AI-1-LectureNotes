package kr.eddi.demo.lectureClass.jpa.board.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;



@Entity
@ToString
@NoArgsConstructor
public class JpaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    //게시판에서 사용할 가장 중요한 규칙을 정함
    // boardId를 식별자로 사용하여 유일하도록 할것임
    // 아이디는 1씩 증감합니다.

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

    @CreationTimestamp
    private LocalDateTime createDate;
    //만든 시간 찍이도록 함

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
