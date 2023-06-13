package kr.eddi.demo.lectureClass.testCode.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
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
