package com.example.demo.problem21.service;

import com.example.demo.problem21.controller.form.ProductRegisterRequest;
import com.example.demo.problem21.controller.form.ProductRequestForm;
import com.example.demo.problem21.entity.Product;

import java.util.List;

public interface ProductService {
    Product register(ProductRegisterRequest requestForm);

    List<Product> list();
}
