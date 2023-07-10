package com.example.demo.mockingTest;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardApiMockingTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JpaBoardService boardService;

    @Test
    @DisplayName("list api 테스트")
    public void list_api_테스트() throws Exception {
        final List<JpaBoard> expectedBoardList = Arrays.asList(
                new JpaBoard("제목1", "작성자1", "내용1"),
                new JpaBoard("제목2", "작성자2", "내용2")
        );

        when(boardService.list()).thenReturn(expectedBoardList);
        // 보드서비스에서 리스트를 실행할 때 뭘 리턴해라~

        mockMvc.perform(MockMvcRequestBuilders.get("/jpa-board/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(expectedBoardList.size()))
                .andExpect(jsonPath("$[0].title").value("제목1"))
                .andExpect(jsonPath("$[0].content").value("내용1"))
                .andExpect(jsonPath("$[0].writer").value("작성자1"))
                .andExpect(jsonPath("$[1].title").value("제목2"))
                .andExpect(jsonPath("$[1].content").value("내용2"))
                .andExpect(jsonPath("$[1].writer").value("작성자2"));

        verify(boardService, times(1)).list();
    }

    @Test
    @DisplayName("register api 테스트")
    public void register_api_테스트() throws Exception {
        final RequestBoardForm boardForm = new RequestBoardForm(
                "제목3", "내용3", "작성자3");

        final JpaBoard board = boardForm.toJpaBoard();

        ObjectMapper objectMapper = new ObjectMapper();

        // Boot 3.x에서는 ObjectMapper를 반드시 사용하도록 한다.
        String content = objectMapper.writeValueAsString(boardForm);

        when(boardService.register(board)).thenReturn(
                board);

        mockMvc.perform(post("/jpa-board/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // 리스트가 아닌 낱개의 경우 length()는 엔티티의 필드(변수) 개수
                // $[0], $[1] 은 리스트
                // 낱개의 경우 $.필드(변수)명으로 작성합니다
                .andExpect(jsonPath("$.length()").value(6))
                .andExpect(jsonPath("$.title").value("제목"))
                .andExpect(jsonPath("$.content").value("내용"))
                .andExpect(jsonPath("$.writer").value("작성자"));
        ;

        verify(boardService, times(1)).register(boardForm.toJpaBoard());
    }
}
