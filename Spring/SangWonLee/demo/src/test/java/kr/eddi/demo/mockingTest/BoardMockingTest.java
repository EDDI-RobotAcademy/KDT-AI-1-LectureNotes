package kr.eddi.demo.mockingTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@ContextConfiguration(classes = DemoApplication.class)
public class BoardMockingTest {

    @Test
    @DisplayName("Mocking 테스트를 준비해보자!")
    void test () {
        assertEquals("안녕", "안녕");
    }
}