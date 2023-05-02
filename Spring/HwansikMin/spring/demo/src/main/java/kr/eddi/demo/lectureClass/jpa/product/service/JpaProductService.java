package kr.eddi.demo.lectureClass.jpa.product.service;

import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;

import java.util.List;

public interface JpaProductService {
    List<JpaProduct> list();
    JpaProduct register(JpaProduct jpaBoard);

    JpaProduct read(Long productId);

    void delete(Long productId);
}