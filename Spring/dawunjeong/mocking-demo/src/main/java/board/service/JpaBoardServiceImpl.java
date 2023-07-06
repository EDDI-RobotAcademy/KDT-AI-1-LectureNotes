package board.service;

import board.controller.form.RequestBoardForm;
import board.entity.JpaBoard;
import board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// JpaBoardService를 상속받아 JpaBoardServiceImpl 클래스를 생성합니다.
@Slf4j
@Service
@RequiredArgsConstructor
public class JpaBoardServiceImpl implements JpaBoardService {

    /*
     JpaBoardRepository 인터페이스 타입의 boardRepository를 선언하여
     JpaBoardRepository 인터페이스를 구현한 클래스의 인스턴스를 사용하겠다는 의미입니다.
     @RequiredArgsConstructor 이 어노테이션에 의해 인터페이스를 직접 사용할 수 있게 됩니다.
     */
    final private JpaBoardRepository boardRepository;

    /*
     list() 매서드
     boardRepository 클래스의 findAll 매서드를 사용하여 JpaBoard 타입의 데이터를 모두 찾고
     boardId를 기준으로 내림차순으로 정렬하여 List<JpaBoard> 타입으로 반환하는 기능입니다.
     */
    @Override
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    /*
     register() 매서드
     boardRepository 클래스의 save 매서드를 사용하여 엔티티 객체 jpaBoard를
     Repository에 저장하고 그 객체를 반환하는 기능입니다.
     */
    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    /*
     read() 매서드
     boardRepository 클래스의 findById 매서드를 사용하여
     boardId를 토대로 엔티티 객체를 조회하고 maybeJpaBoard 변수에 대입합니다.

     Optional을 통해 maybeJpaBoard의 값이 있을 수도 있고 없을 수도 있다는 것을 명시해줍니다.

     Repository에 저장하고 그 객체를 반환하는 기능입니다.
     */
    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaBoard.get();
    }

    /*
     delete() 매서드
     boardRepository 클래스의 deleteById 매서드를 사용하여
     boardId를 토대로 엔티티 객체를 조회하고 그 객체를 삭제합니다.
     */
    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    /*
     modify() 매서드
     boardRepository 클래스의 findById 매서드를 사용하여
     boardId를 토대로 엔티티 객체를 조회하고 maybeJpaBoard 변수에 대입합니다.

     Optional을 통해 maybeJpaBoard의 값이 있을 수도 있고 없을 수도 있다는 것을 명시해줍니다.

     maybeJpaBoard의 값을 board 변수에 대입하고
     board의 title과 content를 requestBoardForm의 title과 content로 지정합니다.

     이후 board를 Repository에 저장하고 그 객체를 반환하는 기능입니다.

     주의해야 할 점은 엔티티를 새로 등록하거나, 수정할 때 모두 save 매서드를 사용한다는 것입니다.
     */
    @Override
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        JpaBoard board = maybeJpaBoard.get();
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());

        return boardRepository.save(board);
    }

}
