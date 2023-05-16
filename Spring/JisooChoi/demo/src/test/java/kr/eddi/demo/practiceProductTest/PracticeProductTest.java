package kr.eddi.demo.practiceProductTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PracticeProductTest {

    @Test
    @DisplayName("회원이 상품을 구매합니다.")
    void 회원이_상품을_구매합니다 () {
        final String email = "test@test.com";
        final Integer password = 1234;
        final String accountRole = "일반회원";
        final Long productId = 1L;


    }
}
