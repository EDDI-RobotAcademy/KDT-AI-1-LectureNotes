package kr.eddi.demo.refactorProduct.service;

import kr.eddi.demo.refactorProduct.service.request.ProductRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Boolean register(ProductRegisterRequest productRegisterRequest, List<MultipartFile> multipartFiles);
    // 상품 등록을 위한 메서드
    ProductReadResponseForm read(Long productId);
    // 사용자의 상품 읽기 요청에 따른 반응
}
