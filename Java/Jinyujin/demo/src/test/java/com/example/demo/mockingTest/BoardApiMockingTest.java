package com.example.demo.mockingTest;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardService;
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
        List<JpaBoard> expectedBoardList = Arrays.asList(
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
}
