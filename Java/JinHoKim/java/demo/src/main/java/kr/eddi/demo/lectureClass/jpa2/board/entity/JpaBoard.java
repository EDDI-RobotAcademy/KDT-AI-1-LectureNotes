//package kr.eddi.demo.lectureClass.jpa2.board.entity;
//
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.data.annotation.CreatedDate;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//@NoArgsConstructor
//@ToString
//@Getter //1
//public class JpaBoard {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long boardId;
//
//    @Setter
//    private String title;
//
//    private String writer;
//
//    @Setter
//    private String content;
//
//    public JpaBoard(String title, String writer, String content) {
//        this.title = title;
//        this.writer = writer;
//        this.content = content;
//    }
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
//    @CreationTimestamp
//    private LocalDateTime createDate;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
//    @UpdateTimestamp
//    private LocalDateTime updateDate;
//}
