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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarOutputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @Test
    @DisplayName("Mocking: 게시물 작성 테스트")
    public void 게시물을_작성합니다 () {
        // 실제 요청될 데이터
        RequestBoardForm boardForm = new RequestBoardForm(
                "제목", "내용", "작성자"
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
        assertEquals(actual.getContent(), board.getContent());
        assertEquals(actual.getWriter(), board.getWriter());
    }
    // 통과했으면 실제로 확인해야 하는 것은 이걸 실제로 통과시켰을 때
    // 디비에 없는가
    // workbench 가서 확인하면 됨

    @Test
    @DisplayName("Mocking: 게시물 리스트 보기 테스트")
    public void 게시물_리스트_보기 () {
        when(mockBoardRepository.findAll())
                .thenReturn(Collections.emptyList());

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final List<JpaBoard> actual = sut.list();

        assertTrue(actual.isEmpty());
    }
    // 터미널 맨 마지막 줄에
    // 오후 3:27:32: Execution finished ':test --tests "com.example.demo.mockingTest.BoardMockingTest.게시물_리스트_보기"'.
    // 이걸로 리스트 보기 테스트가 제대로 되었는지 확인 가능

    @Test
    @DisplayName("Mocking: 게시물 읽기 테스트")
    public void 게시물_읽기 () {
        JpaBoard board = new JpaBoard("제모크", "자크성자", "내애용");
        RequestBoardForm boardForm =
                new RequestBoardForm("제모크", "내애용", "자크성자");

        when(mockBoardRepository.findById(0L))
                .thenReturn(Optional.of(new JpaBoard("제모크", "자크성자", "내애용")));

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);

        final JpaBoard actual = sut.read(0L);
        System.out.println("mocking result: " + actual);
        // toString, manyToOne등 들어가 있는 것들 상황에 따라 잘 사용해야 함

        assertThat(mockBoardRepository.findById(0L).get()).isEqualTo(actual);
    }

    @Test
    @DisplayName("Mocking: 게시물 수정 테스트")
    public void 게시물_수정 () {
        JpaBoard board = new JpaBoard("제모크", "자크성자", "내애용");
        RequestBoardForm boardForm =
                new RequestBoardForm("바꿀제목", "바꿀내용", "자크성자");

        when(mockBoardRepository.findById(0L))
                .thenReturn(Optional.of(new JpaBoard("제모크", "자크성자", "내애용")));

        when(mockBoardRepository.save(any()))
                .thenReturn(new JpaBoard("바꿀제목", "자크성자", "바꿀내용"));

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl((mockBoardRepository));
        final JpaBoard actual = sut.modify(0L, boardForm);
        System.out.println("mocking result: " + actual);

        assertThat(mockBoardRepository.findById(0L).get().getTitle())
                .isEqualTo(actual.getTitle());

        assertThat(mockBoardRepository.findById(0L).get().getContent())
                .isEqualTo(actual.getContent());
    }

    @Test
    @DisplayName("Mocking: 게시물 삭제 테스트")
    public void 게시물_삭제 () {
//        JpaBoard board = new JpaBoard("제목", "작성자", "내용");
//        Optional<JpaBoard> maybeBoard = Optional.of(board);
//
//        when(mockBoardRepository.findById(0L))
//                .thenReturn(maybeBoard);

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        sut.delete(0L);

        verify(mockBoardRepository, times(1)).deleteById(0L);
    }
}
