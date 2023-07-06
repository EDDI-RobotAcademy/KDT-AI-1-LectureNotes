package board.repository;

import board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 스프링 프레임워크에서 제공하는 기본 JpaRepository 인터페이스를 상속받습니다.
 JpaBoard 엔티티와 관련된 CURD 기능을 JpaBoardRepository에서 사용할 수 있게 됩니다.
 JpaRepository<엔티티명, 엔티티 식별자의 데이터 타입> 으로 작성합니다.
 */
public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}
