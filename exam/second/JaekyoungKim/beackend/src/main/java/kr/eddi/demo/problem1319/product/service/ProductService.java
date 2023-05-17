package kr.eddi.demo.problem1319.product.service;

import kr.eddi.demo.problem1319.product.controller.form.ProductRequestForm;
import kr.eddi.demo.problem1319.product.entity.Product;

public interface ProductService {
    Product register(ProductRequestForm requestForm);
}
