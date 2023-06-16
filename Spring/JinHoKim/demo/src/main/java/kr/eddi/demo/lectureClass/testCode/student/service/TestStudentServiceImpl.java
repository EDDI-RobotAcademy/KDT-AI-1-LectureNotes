package kr.eddi.demo.lectureClass.testCode.student.service;

import kr.eddi.demo.lectureClass.testCode.student.entity.TestStudent;
import kr.eddi.demo.lectureClass.testCode.student.repository.TestStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestStudentServiceImpl implements TestStudentService {

    final private TestStudentRepository studentRepository;

    @Override
    public TestStudent register(TestStudent testStudent) {
        final Optional<TestStudent> maybeStudent =
                studentRepository.findByName(testStudent.getName());

        if (maybeStudent.isPresent()) {
            log.info("동일 닉네임의 학생이 존재합니다!");
            return null;
        }

        return studentRepository.save(testStudent);
    }
}
