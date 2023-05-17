package com.example.demo.twentytwoth;

import com.example.demo.problem.account.controller.form.AccountLoginRequestForm;
import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.AccountService;
import com.example.demo.problem.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.problem.product.service.ProductService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.problem.account.entity.RoleType.BUSINESS;
import static com.example.demo.problem.account.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TwentyTwothProblemTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;
    
    @Test
    @DisplayName("토큰 검증")
    void 일반회원_토큰_검증 () {
        final AccountLoginRequestForm requestForm = new AccountLoginRequestForm("test@test.com", "test");
        final String userToken = accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType = accountService.lookup(userToken);

        assertEquals(roleType, NORMAL);
    }

    @Test
    @DisplayName("토큰 검증")
    void 사업자_토큰_검증 () {
        final AccountLoginRequestForm requestForm = new AccountLoginRequestForm("test@gmail.com", "test");
        final String userToken = accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType = accountService.lookup(userToken);

        assertEquals(roleType, BUSINESS);
    }

    @Test
    public void 경로_테스트() {
        String path = System.getProperty("user.dir");
        System.out.println("현재 작업 경로: " + path);
    }

    @Test
    public void Paths_기반_경로_테스트() {
        Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath().toString();
        System.out.println("현재 작업 경로: " + path);
    }

    @Test
    public void Paths_기반_실제_경로_테스트() {
        Path currentPath = Paths.get("src/test/java/com/example/demo/twentytwoth/testImage/glass1.png");
        String path = currentPath.toAbsolutePath().toString();
        System.out.println("Path 기반 현재 실제 작업 경로: " + path);
    }

    @Test
    @DisplayName("토큰 검증")
    void 사업자_상품_등록 () throws IOException {
        final AccountLoginRequestForm requestForm = new AccountLoginRequestForm("test@gmail.com", "test");
        final String userToken = accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType = accountService.lookup(userToken);

        assertEquals(roleType, BUSINESS);

        final ProductRegisterRequestForm productRequestForm =
                new ProductRegisterRequestForm("양말", 1000, "아주 좋음", userToken);

        final File[] files = new File[2];
        final String fixedPath = "src/test/java/com/example/demo/twentytwoth/testImage/";

        Path currentPath = Paths.get(fixedPath + "glass1.png");
        String path = currentPath.toAbsolutePath().toString();
        files[0] = new File(path);

        currentPath = Paths.get(fixedPath + "glass3.png");
        path = currentPath.toAbsolutePath().toString();
        files[1] = new File(path);

        List<MultipartFile> multipartFiles = new ArrayList<>();
        System.out.println(files.length);

        try {
            for(File file : files) {
                FileInputStream input = new FileInputStream(file);
                MultipartFile multiPartFile = new MockMultipartFile(file.getName(), input.readAllBytes());
                multipartFiles.add(multiPartFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("here");
        }
        System.out.println("multipartFiles.get(0).toString(): " + multipartFiles.get(0).toString());
        System.out.println("multipartFiles.get(1).toString(): " + multipartFiles.get(1).toString());

        productService.register(productRequestForm.toProductRegisterRequest(), multipartFiles);
    }
}
