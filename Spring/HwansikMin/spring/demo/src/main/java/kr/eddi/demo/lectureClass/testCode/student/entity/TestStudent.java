package kr.eddi.demo.lectureClass.testCode.student.entity;

import jakarta.persistence.*;
import kr.eddi.demo.lectureClass.testCode.lecture.entity.TestLecture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class TestStudent {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Setter
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private TestLecture testLecture;

    public TestStudent(String name) {
        this.name = name;
    }
}
