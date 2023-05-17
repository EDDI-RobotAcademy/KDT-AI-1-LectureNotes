package kr.eddi.demo.jpa.product.service;

import kr.eddi.demo.jpa.product.controller.form.RequestProductForm;
import kr.eddi.demo.jpa.product.entity.Product;
import kr.eddi.demo.jpa.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;

    @Override
    public List<Product> list() {
            return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
        }


    @Override
    public Product register(Product product) {
        return null;
    }

    @Override
    public Product read(Long productId) {
        return null;
    }

    @Override
    public void delete(Long productId) {

    }

    @Override
    public Product modify(Long productId, RequestProductForm requestProductForm) {
        return null;
    }
}

