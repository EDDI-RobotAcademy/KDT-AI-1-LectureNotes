package kr.eddi.demo.lectureClass.testCode.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //아래로 선언된 변수가 1행이 됨
@NoArgsConstructor
public class TestLecture {
    @Id //이 어노테이션 붙은게 기본(primary key)값
    @Column(name = "lecture_id") //컬럼명 지정 (꼭 필요한 것은아님)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId; //1행1열

    @Getter
    private String lectureName; //1행2열

    public TestLecture(String lectureName) {
        this.lectureName = lectureName;
    }

}
