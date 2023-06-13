package kr.eddi.demo.lectureClass.jpa.product.controller;

import kr.eddi.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;
import kr.eddi.demo.lectureClass.jpa.product.service.JpaProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jpa-product")
public class JpaProductController {

    final private JpaProductService productService;

    @GetMapping("/list")
    public List<JpaProduct> productList() {
        List<JpaProduct> returnedProductList = productService.list();

        return returnedProductList;
    }

    @PostMapping("/register")
    public JpaProduct registerProduct(@RequestBody RequestProductForm requestProductForm) {
        return productService.register(requestProductForm.toJpaProduct());
    }

    @GetMapping("/{productId}")
    public JpaProduct readProduct(@PathVariable Long productId) {
        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public JpaProduct modifyProduct(@PathVariable Long productId,
                                    @RequestBody RequestProductForm requestProductForm) {
        return productService.modify(productId, requestProductForm);
    }
}
