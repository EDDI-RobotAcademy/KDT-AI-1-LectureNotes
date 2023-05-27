package kr.eddi.demo.lectureClass.product.controller;

import kr.eddi.demo.lectureClass.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.product.entity.Product;
import kr.eddi.demo.lectureClass.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    final private ProductService productService;
    @GetMapping("/list")
    public List<Product> productList() {
        log.info("productList()");
        List<Product> returnedProductList = productService.list();
        log.info("returnedProductList: " + returnedProductList);
        return returnedProductList;
    }
    @PostMapping("/register")
    public Product registerProduct (@RequestBody RequestProductForm requestProductForm) {
        log.info("registerBoard()");
        return productService.register(requestProductForm.toProduct());
    }
    @GetMapping("/{productId}")
    public Product readProduct (@PathVariable("productId") Long productId) {
        log.info("readProduct()");
        return productService.read(productId);
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId) {
        log.info("deleteProduct()");

        productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public Product modifyProduct (@PathVariable("productId") Long productId,
                                     @RequestBody RequestProductForm requestProductForm) {
        log.info("modifyProduct(): " + requestProductForm + ", id: " + productId);

        return productService.modify(productId, requestProductForm);
    }
}
