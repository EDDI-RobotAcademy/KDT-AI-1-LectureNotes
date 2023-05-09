package kr.eddi.demo.lectureClass.testCode.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
// @NoArgsConstructor 해주는 이유 :
// 왜 해주는지 이해를 못했는데, 내가 다른 생성자를 만들어줌 으로써,
// 기본 생성자가 자동으로 생성되지 않음으로
// 인수가 없는 생성자를 명시적으로 생성할 수 있다.
public class TestLecture {
    @Id
    @Column(name = "lecture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @Getter
    private String lectureName;

    public TestLecture(String lectureName) {
        this.lectureName = lectureName;
    }
}