package kr.eddi.demo.jpa.product.controller;

import kr.eddi.demo.jpa.product.entity.Product;
import kr.eddi.demo.jpa.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
//현재는 로그를 찍기 위해 사용
@RestController
@RequiredArgsConstructor
//생성자 만들지 않아도 사용하도록 사용
@RequestMapping("/jpa-product")
public class JpaProductController {
    final private ProductService productService;

    @PostMapping("/product-list")
    public List<Product> productList(){
        log.info("productList()");

        List<Product> returnProductList=productService.list();
        log.info("returnedProductList: " + returnProductList);

        return returnProductList;
    }
}
