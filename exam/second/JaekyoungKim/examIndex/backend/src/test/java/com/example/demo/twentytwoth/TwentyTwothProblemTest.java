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
        // 로그인을 위한 폼
        final String userToken = accountService.login(requestForm.toAccountLoginRequest());
        //어카운트 서비스에서 로그인 진행하고 로그인 되면 유저 토큰 받아온다.
        final RoleType roleType = accountService.lookup(userToken);
        // 룩업 이라는 서비스 만들어서 롤타입을 찾을 수 있게 만들어 준다.

        assertEquals(roleType, BUSINESS);
        // 가져온 롤타입이 비즈니스 이니 테스트 한다.

        final ProductRegisterRequestForm productRequestForm =
                new ProductRegisterRequestForm("양말", 1000, "아주 좋음", userToken);
        //상품 이름, 가격, 상태, 유저 토큰을 전달 받을 것이다.

        final File[] files = new File[2];


        final String fixedPath = "src/test/java/com/example/demo/twentytwoth/testImage/";
        // 테스트이기 때문에 고정 주소 사용함

        Path currentPath = Paths.get(fixedPath + "glass1.png");
        // 상품 주소를 체크합니다.
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
