package kr.eddi.demo.lectureClass.testCode.problem.product.service;

import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import kr.eddi.demo.lectureClass.testCode.problem.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final private ProductRepository productRepository;
    @Override
    public Product register(Product product) {
        Optional<Product> maybeProduct = productRepository.findByProductName(product.getProductName());

        if(maybeProduct.isPresent()) {
            log.info("같은 이름의 상품이 존재합니다.");
            return new Product(null, null);
        }
        return productRepository.save(product);
    }
}
