package kr.eddi.demo.lectureClass.vue.files.repository;

import kr.eddi.demo.lectureClass.vue.files.entity.FileTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesTestRepositoty extends JpaRepository<FileTest, Long> {
}
