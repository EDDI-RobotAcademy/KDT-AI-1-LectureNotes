package kr.eddi.demo.refactorProduct.service.request;

import kr.eddi.demo.refactorProduct.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequest {
    private final String productName;
    private final Integer price;
    private final String productInfo;
    public Product toProduct(){
        return new Product(productName,price,productInfo);
    }
}
