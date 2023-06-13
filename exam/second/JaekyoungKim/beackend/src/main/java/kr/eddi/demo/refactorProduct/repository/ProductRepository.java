package kr.eddi.demo.refactorProduct.repository;

import kr.eddi.demo.refactorProduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
