package kr.eddi.demo.refactorProduct.controller.form;

import kr.eddi.demo.refactorProduct.service.request.ProductRegisterRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductRequestForm {
    private final String productName;
    private final Integer price;

    private final String productInfo;

    private final String userToken;

    public ProductRegisterRequest toProductRegisterRequest(){
        return new ProductRegisterRequest(productName,price,productInfo);
    }
}
