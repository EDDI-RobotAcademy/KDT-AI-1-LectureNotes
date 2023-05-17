package kr.eddi.demo.lectureClass.product.service;

import kr.eddi.demo.lectureClass.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product>list();
    Product register(Product product);
    Product read(Long productId);
    void delete(Long productId);
    Product modify(Long productId, RequestProductForm requestProductForm);
}
