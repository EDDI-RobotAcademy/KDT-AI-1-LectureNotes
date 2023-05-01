package kr.eddi.demo.lectureClass.jpa.product.service;

import kr.eddi.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;
import kr.eddi.demo.lectureClass.jpa.product.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaProductServiceImpl implements JpaProductService {

    final private JpaProductRepository productRepository;

    @Override
    public List<JpaProduct> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public JpaProduct register(JpaProduct jpaProduct) {
        return productRepository.save(jpaProduct);
    }

    @Override
    public JpaProduct read(Long productId) {
        Optional<JpaProduct> maybeJpaProduct = productRepository.findById(productId);

        if (maybeJpaProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaProduct.get();
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public JpaProduct modify(Long productId, RequestProductForm requestProductForm) {
        Optional<JpaProduct> maybeJpaProduct = productRepository.findById(productId);

        if (maybeJpaProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        JpaProduct product = maybeJpaProduct.get();
        product.setProductName(requestProductForm.getProductName());
        product.setPrice(requestProductForm.getPrice());

        return productRepository.save(product);
    }
}
