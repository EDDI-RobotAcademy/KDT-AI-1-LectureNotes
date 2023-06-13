package com.example.demo.exam10Test;

import com.example.demo.exam.exam10To30.account.form.AccountRegisterForm;
import com.example.demo.exam.exam10To30.account.entity.RoleType;
import com.example.demo.exam.exam10To30.account.service.AccountService;
import com.example.demo.exam.exam10To30.account.form.LoginRequestForm;
import com.example.demo.exam.exam10To30.account.form.LoginResponseForm;
import com.example.demo.exam.exam10To30.product.entity.Product;
import com.example.demo.exam.exam10To30.product.entity.ProductImage;
import com.example.demo.exam.exam10To30.product.form.ProductRegisterForm;
import com.example.demo.exam.exam10To30.product.repository.ProductImageRepository;
import com.example.demo.exam.exam10To30.product.repository.ProductRepository;
import com.example.demo.exam.exam10To30.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.example.demo.exam.exam10To30.account.entity.RoleType.BUSINESS;
import static com.example.demo.exam.exam10To30.account.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ExamTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("11번 일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "test@test.com";
        final String password = "test";
        final RoleType roleType = NORMAL;

        AccountRegisterForm registerForm = new AccountRegisterForm(email, password, roleType, null);
        Boolean isSuccess = accountService.register(registerForm.toAccountRegisterRequest());

        assertTrue(isSuccess);
    }

    @Test
    @DisplayName("12번 사업자 회원 가입")
    void 사업자_회원_가입 () {
        final String email = "business@test.com";
        final String password = "test";
        final RoleType roleType = BUSINESS;
        final String businessNumber = "1111111111";

        AccountRegisterForm registerForm = new AccountRegisterForm(email, password, roleType, businessNumber);
        Boolean isSuccess = accountService.register(registerForm.toAccountRegisterRequest());

        assertTrue(isSuccess);
    }

    @Test
    @DisplayName("18번 사용자 로그인")
    void 사용자_로그인 () {
        final String email = "test@test.com";
        final String password = "test";
        final Long exactAccountId = 1L;

        LoginRequestForm requestForm = new LoginRequestForm(email, password);
        LoginResponseForm realAccount = accountService.login(requestForm);

        assertEquals(exactAccountId, realAccount.getAccountId());
    }

    @Test
    @DisplayName("22번 사업자 상품 등록")
    void 사업자_상품_등록 () throws IOException {
        final String email = "business@test.com";
        final String password = "test";

        LoginRequestForm loginForm = new LoginRequestForm(email, password);
        LoginResponseForm loggedInForm = accountService.login(loginForm);
        Boolean isBusiness = accountService.checkRole(loggedInForm);

        final String name = "testName";
        final Integer price = 1234;

        String fileName = "charmander";
        String contentType = "png";
        String filePath = "../frontend/src/assets/imgs/charmander.png";
        MockMultipartFile mockMultipartFile = getMockMultipartFile(fileName, contentType, filePath);


        ProductRegisterForm productRegisterForm = new ProductRegisterForm(name,price);
        productService.register(mockMultipartFile, productRegisterForm.toProductRegisterRequest(mockMultipartFile));

        assertTrue(isBusiness);

    }

    private MockMultipartFile getMockMultipartFile(String fileName, String contentType, String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        return new MockMultipartFile(fileName, fileName + "." + contentType, contentType, fileInputStream);
    }
}
