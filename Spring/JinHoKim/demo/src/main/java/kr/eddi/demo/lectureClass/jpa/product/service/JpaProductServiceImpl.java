package kr.eddi.demo.lectureClass.jpa.product.service;

import kr.eddi.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;
import kr.eddi.demo.lectureClass.jpa.product.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaProductServiceImpl implements JpaProductService{

    final private JpaProductRepository productRepository;

    @Override
    public List<JpaProduct> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"productId"));
    }

    @Override
    public JpaProduct register(JpaProduct jpaProduct) {
        return productRepository.save(jpaProduct);
    }

    @Override
    public JpaProduct read(Long productId) {
        Optional<JpaProduct> maybeProduct = productRepository.findById(productId);
        if (maybeProduct.isEmpty()) {
            return null;
        }
        return maybeProduct.get();
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public JpaProduct modify(Long productId, RequestProductForm requestProductForm) {
        Optional<JpaProduct> maybeProduct = productRepository.findById(productId);
        if (maybeProduct.isEmpty()) {
            return null;
        }

        JpaProduct product = maybeProduct.get();
        product.setProductName(requestProductForm.getProductName());
        product.setPrice(requestProductForm.getPrice());
        return productRepository.save(product);
    }
}
