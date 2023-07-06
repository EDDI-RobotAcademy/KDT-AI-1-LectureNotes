package kr.eddi.demo.MockingTest;

import kr.eddi.demo.board.controller.form.RequestBoardForm;
import kr.eddi.demo.board.entity.JpaBoard;
import kr.eddi.demo.board.repository.JpaBoardRepository;
import kr.eddi.demo.board.service.JpaBoardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BoardMockingTest {

    @Mock
    private JpaBoardRepository mockBoardRepository;

    @InjectMocks
    private JpaBoardServiceImpl mockBoardService;

    @BeforeEach
    public void setup () throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Mocking 테스트를 준비합니다.")
    void test () {
        System.out.println("준비하라고!");
    }

    @Test
    @DisplayName("Mocking: 게시물 작성 테스트")
    public void 게시물을_작성합니다 () {
        // 실제 요청될 데이터
        final RequestBoardForm boardForm = new RequestBoardForm(
                "제목","내용", "작성자"
        );
        final JpaBoard board = boardForm.toJpaBoard();

        // 가상의 예측되는 결과
        when(mockBoardRepository.save(board))
                .thenReturn(new JpaBoard("제목", "작성자", "내용"));

        // 실제 구동 테스트
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final JpaBoard actual = sut.register(board);

        // 예측 결과와 실제 데이터의 비교
        assertEquals(actual.getTitle(), board.getTitle());
        assertEquals(actual.getWriter(), board.getWriter());
        assertEquals(actual.getContent(), board.getContent());
    }

    @Test
    @DisplayName("Mocking: 게시물 리스트 보기 테스트")
    public void 게시물을_리스트_보기 () {
        when(mockBoardRepository.findAll())
                .thenReturn(Collections.emptyList());

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final List<JpaBoard> actual = sut.list();

        assertTrue(actual.isEmpty());
    }
}
