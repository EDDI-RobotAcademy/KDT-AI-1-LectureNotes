package com.example.demo.secondExam.test22.service;

import com.example.demo.secondExam.test22.controller.form.Test22ProductRequestForm;
import com.example.demo.secondExam.test22.entity.Test22Product;
import com.example.demo.secondExam.test22.repository.Test22ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class Test22ProductServiceImpl implements Test22ProductService {

    @Autowired
    private Test22ProductRepository productRepository;

    @Override
    public Test22Product register(Test22ProductRequestForm productRequestForm){
        final String businessRole = "사업자";
        if((productRequestForm.getBusinessUser()).equals(businessRole)){
            return productRepository.save(productRequestForm.toTest22Product());
        }

        log.info("사업자가 아니므로 상품을 등록할 수 없습니다.");
        return null;
    }

    @Override
    public List<Test22Product> list(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }
}
