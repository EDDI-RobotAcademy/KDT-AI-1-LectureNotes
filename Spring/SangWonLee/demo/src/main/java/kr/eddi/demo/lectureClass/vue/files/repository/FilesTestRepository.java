package kr.eddi.demo.lectureClass.vue.files.repository;

import kr.eddi.demo.lectureClass.vue.files.entity.FileTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesTestRepository extends JpaRepository<FileTest, Long> {
    // JpaRepository 인터페이스를 상속받는다. 이 때 사용될 Entity class와 ID값이 들어가게 된다.
    // 즉, JpaRepository<Entity, ID> 가 된다.
    // 지금 여기서는 FileTest 엔티티 클래스와 Long 타입의 ID 값을 사용하고 있다.
}