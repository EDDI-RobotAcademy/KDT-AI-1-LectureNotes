package kr.eddi.demo.testTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testTest {
    @Test
    @DisplayName("일반회원 회원가입")
    void 일반회원이_회원가입합니다(){}

    @Test
    @DisplayName("사업자회원 회원가입")
    void 사업자회원이_회원가입합니다(){}
}
