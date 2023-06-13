package kr.eddi.demo.refactorProduct.controller.form;

import kr.eddi.demo.refactorProduct.entity.Product;
import kr.eddi.demo.refactorProduct.entity.ProductImages;

import java.util.ArrayList;
import java.util.List;

public class ProductReadResponseForm {
    final private Long id;
    final private String productName;
    final private Integer price;
    final private String productInfo;
    final private List<String> productImagesPathList=new ArrayList<>();

    public ProductReadResponseForm(Product product, List<ProductImages> productImagesList){
        this.id= product.getId();
        this.productName=product.getProductName();
        this.price=product.getPrice();
        this.productInfo=product.getProductInfo();

        for (ProductImages images:productImagesList){
            this.productImagesPathList.add(images.getImageResourcePath());
        }
    }

}
