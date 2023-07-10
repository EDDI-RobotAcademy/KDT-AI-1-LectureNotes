package kr.eddi.demo.mockingTest;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.repository.JpaBoardRepository;
import kr.eddi.demo.lectureClass.jpa.board.service.JpaBoardServiceImpl;
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
import static org.mockito.Mockito.*;

// Spring Boot 테스트 환경 설정
@SpringBootTest
public class BoardMockingTest {

    // JpaBoardRepository를 가짜 객체로 생성
    @Mock
    private JpaBoardRepository mockBoardRepository;

    // JpaBoardServiceImpl 객체에 가짜 JpaBoardRepository 주입
    @InjectMocks
    private JpaBoardServiceImpl mockBoardService;

    // 테스트 케이스가 실행되기 전에 수행되는 메서드 정의
    @BeforeEach
    public void setup() throws Exception {
        // Mockito 어노테이션 초기화
        MockitoAnnotations.initMocks(this);
    }

    // Mockito 테스트 준비를 위한 테스트 케이스
    @Test
    @DisplayName("Mocking 테스트를 준비합니다.")
    void test() {
        System.out.println("준비하라고!");
    }

    // 게시물 작성 테스트 케이스
    @Test
    @DisplayName("Mocking: 게시물 작성 테스트")
    public void 게시물을_작성합니다() {
        // 실제 요청될 데이터 생성
        final RequestBoardForm boardForm = new RequestBoardForm("제목", "내용", "작성자");
        final JpaBoard board = boardForm.toJpaBoard();

        // mockBoardRepository의 반환 값을 설정
        when(mockBoardRepository.save(board)).thenReturn(new JpaBoard("제목", "작성자", "내용"));

        // 테스트할 메서드 호출
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final JpaBoard actual = sut.register(board);

        // 호출 결과와 예상 결과를 비교
        assertEquals(actual.getTitle(), board.getTitle());
        assertEquals(actual.getWriter(), board.getWriter());
        assertEquals(actual.getContent(), board.getContent());
    }

    // 게시물 리스트 보기 테스트 케이스
    @Test
    @DisplayName("Mocking: 게시물 리스트 보기 테스트")
    public void 게시물을_리스트_보기() {
        // mockBoardRepository의 반환 값을 설정
        when(mockBoardRepository.findAll()).thenReturn(Collections.emptyList());

        // 테스트할 메서드 호출
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final List<JpaBoard> actual = sut.list();

        // 반환된 결과는 비어있음을 확인
        assertTrue(actual.isEmpty());
    }

    // 게시물 읽기 테스트 케이스
    @Test
    @DisplayName("Mocking: 게시물 읽기 테스트")
    public void 게시물_읽기() {
        // 가짜 게시물 생성
        JpaBoard board = new JpaBoard("제모크", "자크성자", "내애용");
        RequestBoardForm boardForm = new RequestBoardForm("제모크", "자크성자", "내애용");

        // mockBoardRepository의 반환 값을 설정
        when(mockBoardRepository.findById(0L)).thenReturn(Optional.of(new JpaBoard("제모크", "자크성자", "내애용")));

        // 테스트할 메서드 호출
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final JpaBoard actual = sut.read(0L);

        // 반환된 결과와 가짜 게시물을 비교
        assertThat(mockBoardRepository.findById(0L).get()).isEqualTo(actual);
    }

    // 게시물 수정 테스트 케이스
    @Test
    @DisplayName("Mocking: 게시물 수정 테스트")
    public void 게시물_수정() {
        // 가짜 게시물 생성
        JpaBoard board = new JpaBoard("제모크", "자크성자", "내애용");
        RequestBoardForm boardForm = new RequestBoardForm("바꿀제목", "바꿀내용", "자크성자");

        // mockBoardRepository의 반환 값을 설정
        when(mockBoardRepository.findById(0L)).thenReturn(Optional.of(new JpaBoard("제모크", "자크성자", "내애용")));
        when(mockBoardRepository.save(any())).thenReturn(new JpaBoard("바꿀제목", "자크성자", "바꿀내용"));

        // 테스트할 메서드 호출
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        final JpaBoard actual = sut.modify(0L, boardForm);

        // 반환된 결과와 수정된 가짜 게시물을 비교
        assertThat(mockBoardRepository.findById(0L).get().getTitle()).isEqualTo(actual.getTitle());
        assertThat(mockBoardRepository.findById(0L).get().getContent()).isEqualTo(actual.getContent());
    }

    // 게시물 삭제 테스트 케이스
    @Test
    @DisplayName("Mocking: 게시물 삭제 테스트")
    public void 게시물_삭제() {
        // 테스트할 메서드 호출
        final JpaBoardServiceImpl sut = new JpaBoardServiceImpl(mockBoardRepository);
        sut.delete(0L);

        // mockBoardRepository의 deleteById 메서드가 한 번 호출되었음을 확인
        verify(mockBoardRepository, times(1)).deleteById(0L);
    }
}

