package kr.eddi.demo.jpa.product.repository;

import kr.eddi.demo.jpa.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
