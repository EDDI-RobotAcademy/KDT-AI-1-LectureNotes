package kr.eddi.demo;

import kr.eddi.demo.RefactorAccount.controller.form.RefactorLoginRequestForm;
import kr.eddi.demo.RefactorAccount.entity.RoleType;
import kr.eddi.demo.RefactorAccount.service.RefactorAccountService;
import kr.eddi.demo.refactorProduct.controller.form.ProductRequestForm;
import kr.eddi.demo.refactorProduct.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static kr.eddi.demo.RefactorAccount.entity.RoleType.BUSINESS;
import static kr.eddi.demo.RefactorAccount.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ReProblem22 {
    @Autowired
    private RefactorAccountService accountService;
    @Autowired
    private ProductService productService;
    @Test
    @DisplayName("토큰 검증")
    void 일반회원_토큰_검증(){
        final RefactorLoginRequestForm requestForm = new RefactorLoginRequestForm("post@post.com", "post");
        final String userToken=accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType=accountService.lookup(userToken);

        assertEquals(roleType,NORMAL);
    }
    @Test
    @DisplayName("사업자 회원 토큰 검증")
    void 사업자_토큰_검증(){
        final RefactorLoginRequestForm requestForm = new RefactorLoginRequestForm("busy@post.com", "busy");
        final String userToken=accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType=accountService.lookup(userToken);

        assertEquals(roleType,BUSINESS);
    }

    @Test
    public void 경로_테스트(){
        String path = System.getProperty("user.dir");
        System.out.println("현재 작업 경로 :"+path );
    }

    @Test
    @DisplayName("토큰 검증")
    void 사업자_상품_등록() throws IOException{
        final RefactorLoginRequestForm requestForm = new RefactorLoginRequestForm("busy@busy.com", "busy");
        final String userToken=accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType=accountService.lookup(userToken);

        assertEquals(roleType,BUSINESS);

        final ProductRequestForm productRegisterRequestForm = new ProductRequestForm("양말",1000,"아주 좋음", userToken);
        final File[] files=new File[2];
        final  String fixedPath="src/test/java/com/example/demo/twentytwoth/testImage/";

        Path currentPath = Paths.get(fixedPath+"glass1.png");
        String path=currentPath.toAbsolutePath().toString();
        files[0]=new File(path);

        currentPath = Paths.get(fixedPath + "glass3.png");
        path= currentPath.toAbsolutePath().toString();
        files[1]=new File(path);

        List<MultipartFile> multipartFiles = new ArrayList<>();
        System.out.println(files.length);

        try {
            for (File file:files){
                FileInputStream input =new FileInputStream(file);
                MultipartFile multipartFile = new MockMultipartFile(file.getName(),input.readAllBytes());
                multipartFiles.add(multipartFile);
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("here");

        }
        System.out.println("multipartFiles.get(0).toString(): "+multipartFiles.get(0).toString());

        productService.register(productRegisterRequestForm.toProductRegisterRequest(), multipartFiles)

    }
}
