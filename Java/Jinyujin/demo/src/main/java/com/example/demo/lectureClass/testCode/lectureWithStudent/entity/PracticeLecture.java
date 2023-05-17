package com.example.demo.lectureClass.testCode.lectureWithStudent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "LectureType")
// 요것을 설정해줘야지 테이블에서 이름이 lecture_type으로 뜸!
public class PracticeLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Getter
//    private String name;
    // 요것이 있을 필요가 없어보임
    // 필요없음
    // lecture_type으로 이름이 정해지기 때문에 따로 이름을 써줄 필요가 없음

    @Enumerated(EnumType.STRING)
    @Getter
    private LectureType lectureType;

//    public PracticeLecture(String name) {
//        this.name = name;
//    }
    // student도 같이 넣어줘야 하나?
    // 웅 안넣으니까 테이블에 student_id가 null값으로 뜨네

    // Register 엔티티를 새로 만들어줬기 때문에
    // Lecture에 student를 연결시켜줄 필요가 없어보임

    public PracticeLecture(LectureType lectureType) {
        this.lectureType = lectureType;
    }
}
