package com.example.demo.evaluation.problem21_26.service;


import com.example.demo.evaluation.problem21_26.controller.form.ProductRegisterRequestForm;
import com.example.demo.evaluation.problem21_26.entity.Product;

import java.util.List;

public interface ProductService {
    Product register(ProductRegisterRequestForm productRegisterRequestForm);

    List<Product> list();

    Product read(Long id);
}
