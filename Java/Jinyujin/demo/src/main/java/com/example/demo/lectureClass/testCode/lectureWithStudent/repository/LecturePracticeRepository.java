package com.example.demo.lectureClass.testCode.lectureWithStudent.repository;

import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.LectureType;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturePracticeRepository extends JpaRepository<PracticeLecture, Long> {
//    Optional<PracticeLecture> findByName(String subject);

    PracticeLecture findByLectureType(LectureType lectureType);
    // 수강신청 과목이 정해져 있고 그 중에 선택해서 넘어오니
    // 이니셜라이저로 서버와 동기화 되니까
    // 굳이 Optional사용하지 않아도 되는 것!
}
