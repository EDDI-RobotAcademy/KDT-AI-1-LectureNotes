package kr.eddi.demo.lectureClass.jpa.product.controller;


import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.jpa.product.entity.ProductEntity;
import kr.eddi.demo.lectureClass.jpa.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductProblemController {

    final private ProductService productService;

    @PostMapping("/register")
    public ProductEntity registerProduct(@RequestBody RequestProductForm requestProductForm){
        log.info("registerProduct()");

        return productService.register(requestProductForm.toProductEntity());
    }


}
