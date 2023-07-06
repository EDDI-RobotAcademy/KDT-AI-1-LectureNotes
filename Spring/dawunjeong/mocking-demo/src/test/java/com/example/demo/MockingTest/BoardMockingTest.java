package com.example.demo.MockingTest;

import board.controller.form.RequestBoardForm;
import board.entity.JpaBoard;
import board.repository.JpaBoardRepository;
import board.service.JpaBoardServiceImpl;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

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

    @Test
    @DisplayName("Mocking: 게시물 읽기 테스트")
    public void 게시물_읽기 () {
        JpaBoard board = new JpaBoard("제모크", "자크성자", "내애용");
        RequestBoardForm boardForm =
                new RequestBoardForm("제모크", "자크성자", "내애용");

        when(mockBoardRepository.findById(0L))
                .thenReturn(Optional.of(
                        new JpaBoard("제모크", "자크성자", "내애용")));

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);

        final JpaBoard actual = sut.read(0L);
        System.out.println("mocking result: " + actual);

        assertThat(mockBoardRepository.findById(0L).get()).isEqualTo(actual);
    }

    @Test
    @DisplayName("Mocking: 게시물 수정 테스트")
    public void 게시물_수정 () {
        JpaBoard board = new JpaBoard("제모크", "자크성자", "내애용");
        RequestBoardForm boardForm =
                new RequestBoardForm("바꿀제목", "바꿀내용", "자크성자");

        when(mockBoardRepository.findById(0L))
                .thenReturn(Optional.of(
                        new JpaBoard("제모크", "자크성자", "내애용")));

        when(mockBoardRepository.save(any()))
                .thenReturn(new JpaBoard("바꿀제목", "자크성자", "바꿀내용"));

        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);

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
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        sut.delete(0L);

        verify(mockBoardRepository, times(1)).deleteById(0L);
    }
}
