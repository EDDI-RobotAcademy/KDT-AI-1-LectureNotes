package com.example.demo.secondExam.test22.service;

import com.example.demo.secondExam.test22.controller.form.Test22ProductRequestForm;
import com.example.demo.secondExam.test22.entity.Test22Product;

import java.util.List;


public interface Test22ProductService {

    Test22Product register(Test22ProductRequestForm productRequestForm);

    List<Test22Product> list();
}
