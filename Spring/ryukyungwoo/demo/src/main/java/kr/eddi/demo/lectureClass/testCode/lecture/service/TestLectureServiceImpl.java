package kr.eddi.demo.lectureClass.testCode.lecture.service;

import kr.eddi.demo.lectureClass.testCode.lecture.entity.TestLecture;
import kr.eddi.demo.lectureClass.testCode.lecture.repository.TestLectureRepository;
import kr.eddi.demo.lectureClass.testCode.student.entity.TestStudent;
import kr.eddi.demo.lectureClass.testCode.student.repository.TestStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestLectureServiceImpl implements TestLectureService {

    final private TestLectureRepository lectureRepository;
    final private TestStudentRepository studentRepository;

    @Override
    public TestLecture register(String subject, Long studentId) {

        final TestLecture testLecture = new TestLecture(subject);
        lectureRepository.save(testLecture);

        final Optional<TestStudent> maybeStudent = studentRepository.findById(studentId);

        if (maybeStudent.isPresent()) {
            log.info("중복된 학생입니다!");
            return null;
        }

        final TestStudent testStudent = maybeStudent.get();
        testStudent.setTestLecture(testLecture);
        studentRepository.save(testStudent);

        return testLecture;
    }

    private Boolean checkDuplicateOfLecture(String subject) {
        final Optional<TestLecture> maybeLecture = lectureRepository.findByLectureName(subject);

        if (maybeLecture.isEmpty()) {
            log.info("중복 없음");
            return false;
        }

        return true;
    }
}
