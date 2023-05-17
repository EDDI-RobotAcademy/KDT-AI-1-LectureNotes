package kr.eddi.demo.lectureClass.jpa.board.repository;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

    //           ↓이 틀을 제공해준다.           ↓이걸 상속해와서
public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
    // 자바 interface 란 ?
    // 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서
    // 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스를 말한다.

    // extends 가 하는 역할 ?
    // 부모의 메서드를 그대로 사용할 수 있으며,
    // 오버라이딩 할 필요 없이 부모에 구현되어 있는 것을 직접 사용 가능하다.

    // JpaRepository<엔티티, ID 유형> ?
    // Spring Framework 에서 데이터 검색을 할 수 있는 구조가 제대로 준비되어 있는데 그것이 이것이다.
    // 인터페이스에 미리 검색 메서드를 정의해 두는 것으로,
    // 메서드를 호출하는 것만으로 스마트한 데이터 검색을 할 수 있게 되는 것이다.
}
