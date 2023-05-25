package com.example.demo.lectureClass.testCode.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// JPA는 Entity 키워드가 붙은 녀석들과 직접적인 관계가 있다.
// Entity 클래스를 보고 나머지 작업을 자동화하라는 지시어 역할이라고 봐도 무방하다.
// (저장 - save, 수정 - save, 삭제 - delete, 조회 - find)
@Entity
@NoArgsConstructor
public class TestLecture {
    @Id
    // 객체 필드를 테이블의 컬럼에 매핑시켜주는 어노테이션
    @Column(name = "lecture_id")
    // 기본키 자동 생성을 데이터베이스에 위임함.
    // 즉, id 값을 null로 하면 DB가 알아서 AUTO_INCREMENT 해준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @Getter
    private String lectureName;

    public TestLecture(String lectureName) {
        this.lectureName = lectureName;
    }
}
