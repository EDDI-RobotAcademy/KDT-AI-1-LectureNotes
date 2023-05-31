package com.example.demo.problem21;

import com.example.demo.problem21.controller.form.ProductRequestForm;
import com.example.demo.problem21.entity.ProductExam;
import com.example.demo.problem21.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;

@SpringBootTest
public class ProductRegisterTest {
    /*
        1. 사업자 회원이라면 요청한 상품을 등록할 수 있도록 합니다
           - 상품 정보와 상품 이미지에 대한 정보를 받습니다
           - 상품 이미지는 타입을 설정하여 읽어오도록 해줍니다

           - OneToOne 어노테이션을 이용하여 Product 엔티티와 ProductImage 엔티티를 맵핑해줍니다
           - 상품이미지에는 UUID를 주고 String으로 만드는 메서드를 이용하여 등록되도록 합니다
     */

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품 등록")
    void 상품_등록() {

        final String productName = "상품";
        final Integer price = 10000;
        final MultipartFile imageFile = new MockMultipartFile(
                "imageFile",
                "apeach.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "test image".getBytes()
        );

        ProductRequestForm requestForm = new ProductRequestForm(productName, price);

        ProductExam product = productService.register(requestForm.toProductRequest(imageFile));
    }
}
