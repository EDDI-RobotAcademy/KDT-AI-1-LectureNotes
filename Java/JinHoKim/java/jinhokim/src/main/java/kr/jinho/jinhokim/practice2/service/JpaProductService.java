package kr.jinho.jinhokim.practice2.service;

import kr.jinho.jinhokim.practice2.controller.form.RequestProductForm;
import kr.jinho.jinhokim.practice2.entity.JpaProduct;

import java.util.List;

public interface JpaProductService {
    List<JpaProduct> list();

    JpaProduct register(JpaProduct jpaProduct);

    JpaProduct read(Long productId);

    void delete(Long productId);

    JpaProduct modify(Long productId, RequestProductForm requestProductForm);
}
