package kr.eddi.demo.lectureClass.jpa.product.controller;

import kr.eddi.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;
import kr.eddi.demo.lectureClass.jpa.product.service.JpaProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-product")
public class JpaProductController {

    final private JpaProductService productService;

    @GetMapping("/list")
    public List<JpaProduct> productList() {
        log.info("productList()");

        List<JpaProduct> returnedProductList = productService.list();
        log.info("returnedProductList: " + returnedProductList);

        return returnedProductList;
    }

    @PostMapping("/register")
    public JpaProduct registerProduct (@RequestBody RequestProductForm requestProductForm) {
        log.info("registerBoard()");

        return productService.register(requestProductForm.toJpaProduct());
    }

    @GetMapping("/{productId}")
    public JpaProduct readProduct (@PathVariable("productId") Long productId) {
        log.info("readProduct()");

        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId) {
        log.info("deleteProduct()");

        productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public JpaProduct modifyProduct (@PathVariable("productId") Long productId,
                                 @RequestBody RequestProductForm requestProductForm) {
        log.info("modifyProduct(): " + requestProductForm + ", id: " + productId);

        return productService.modify(productId, requestProductForm);
    }
}
