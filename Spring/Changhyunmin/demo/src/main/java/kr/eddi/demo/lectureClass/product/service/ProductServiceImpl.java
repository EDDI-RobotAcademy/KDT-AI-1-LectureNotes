package kr.eddi.demo.lectureClass.product.service;

import kr.eddi.demo.lectureClass.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.product.entity.Product;
import kr.eddi.demo.lectureClass.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final private ProductRepository productRepository;
    @Override
    public List<Product> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"productId"));
    }

    @Override
    public Product register(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long productId) {
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            log.info("정보가 없습니다.");
            return null;
        }
        return maybeProduct.get();
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product modify(Long productId, RequestProductForm requestProductForm) {
        Optional<Product> maybeProduct = productRepository.findById(productId);
        if (maybeProduct.isEmpty()){
            log.info("정보가 없습니다!");
            return null;
        }
        Product product = maybeProduct.get();
        product.setProductName(requestProductForm.getProductName());
        product.setPrice(requestProductForm.getPrice());

        return productRepository.save(product);
    }
}
