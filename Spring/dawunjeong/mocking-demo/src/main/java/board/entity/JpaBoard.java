package board.entity;

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

// 현재 비즈니스 서비스 도메인에서 관리할 엔티티 : 게시글
@Entity
@Getter
@ToString
@NoArgsConstructor
public class JpaBoard {

    /*
    게시글은 boardId, title, writer, content, createDate, updateDate라는 6개의 속성을 갖습니다.

    1. boardId는 이 엔티티의 key가 되며 @GeneratedValue과 GenerationType.IDENTITY에 의해 자동으로 1부터 생성됩니다.
    2. title, writer, content는 이 엔티티 객체를 생성할 때 외부에서 받아오는 값입니다.
    3. createDate과 updateDate는 @CreationTimestamp, @UpdateTimestamp 어노테이션에 의해 자동으로 생성됩니다.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    // 게시글을 수정할 때 값을 변경해줄 수 있는 title과 content에만 setter를 설정합니다.
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
