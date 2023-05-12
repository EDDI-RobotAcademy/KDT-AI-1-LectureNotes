package kr.eddi.demo.lectureClass.jpa.files.repository;

import kr.eddi.demo.lectureClass.jpa.files.entity.FileTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesTestRepository extends JpaRepository<FileTest, Long> {
}
