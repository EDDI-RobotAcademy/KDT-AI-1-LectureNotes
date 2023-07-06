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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        final RequestBoardForm boardForm = new RequestBoardForm(
                "제목","내용", "작성자"
        );
        final JpaBoard board = boardForm.toJpaBoard();

        when(mockBoardRepository.save(board))
                .thenReturn(new JpaBoard("제목", "작성자", "내용"));

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final JpaBoard actual = sut.register(board);

        assertEquals(actual.getTitle(), board.getTitle());
        assertEquals(actual.getWriter(), board.getWriter());
        assertEquals(actual.getContent(), board.getContent());
    }
}
