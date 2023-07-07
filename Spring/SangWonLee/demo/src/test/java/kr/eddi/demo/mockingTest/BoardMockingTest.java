package kr.eddi.demo.mockingTest;

import kr.eddi.demo.DemoApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ContextConfiguration(classes = DemoApplication.class)
public class BoardMockingTest {

    @Test
    @DisplayName("Mocking 테스트를 준비해보자!")
    void test () {
        assertEquals("안녕", "안녕");
    }
}
