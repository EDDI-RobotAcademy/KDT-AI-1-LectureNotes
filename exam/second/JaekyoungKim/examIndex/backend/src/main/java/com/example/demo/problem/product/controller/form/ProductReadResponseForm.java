package com.example.demo.problem.product.controller.form;

import com.example.demo.problem.product.entity.Product;
import com.example.demo.problem.product.entity.ProductImages;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductReadResponseForm {

    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productDetails;
    final private List<String> productImagesPathList = new ArrayList<>();

    public ProductReadResponseForm(Product product, List<ProductImages> productImagesList) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDetails = product.getProductDetails();

        for (ProductImages images: productImagesList) {
            this.productImagesPathList.add(images.getImageResourcePath());
        }
    }
}
