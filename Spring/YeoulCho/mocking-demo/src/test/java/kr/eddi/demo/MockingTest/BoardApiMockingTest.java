package kr.eddi.demo.MockingTest;

import kr.eddi.demo.board.entity.JpaBoard;
import kr.eddi.demo.board.service.JpaBoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

        mockMvc.perform(get("/jpa-board/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.length()").value(expectedBoardList.size()))
                .andExpect(jsonPath("$[0].title").value("제목1"))
                .andExpect(jsonPath("$[0].writer").value("작성자1"))
                .andExpect(jsonPath("$[0].content").value("내용1"))
                .andExpect(jsonPath("$[1].title").value("제목2"))
                .andExpect(jsonPath("$[1].writer").value("작성자2"))
                .andExpect(jsonPath("$[1].content").value("내용2"))

        ;

        verify(boardService, times(1)).list();
    }

}
