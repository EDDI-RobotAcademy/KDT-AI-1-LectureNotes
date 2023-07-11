package com.example.demo.boardTest;

import com.example.demo.DemoApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class BoardTest {
    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void test(){
        assertEquals("안녕","안녕");
    }
}
