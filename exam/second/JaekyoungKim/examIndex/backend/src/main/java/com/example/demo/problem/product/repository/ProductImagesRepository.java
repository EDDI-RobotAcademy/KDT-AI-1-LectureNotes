package com.example.demo.problem.product.repository;

import com.example.demo.problem.product.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    @Query("select pi from ProductImages pi join fetch pi.product p where p.id = :productId")
    List<ProductImages> findImagePathByProductId(Long productId);
}
