package com.example.demo.mockingTest;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.repository.JpaBoardRepository;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardServiceImpl;
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

    // 항상 구동되어야 하는 것
    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Mocking Test를 준비해보자!")
    void test () {
//        System.out.println("안녕!");
        assertEquals("안녕", "안녕");
    }

    // 이렇게 되면 실제 디비에 안넣고 테스트 가능!
    @Test@DisplayName("Mocking: 게시물 작성 테스트")
    public void 게시물을_작성합니다 () {
        RequestBoardForm boardForm = new RequestBoardForm(
                "제목", "내용", "작성자"
        );
        final JpaBoard board = boardForm.toJpaBoard();

        when(mockBoardRepository.save(board))
                .thenReturn(new JpaBoard("제목", "작성자", "내용"));

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final JpaBoard actual = sut.register(board);

        assertEquals(actual.getTitle(), board.getTitle());
        assertEquals(actual.getContent(), board.getContent());
        assertEquals(actual.getWriter(), board.getWriter());
    }

    // 통과했으면 실제로 확인해야 하는 것은 이걸 실제로 통과시켰을 때
    // 디비에 없는가
    // workbench 가서 확인하면 됨
}
