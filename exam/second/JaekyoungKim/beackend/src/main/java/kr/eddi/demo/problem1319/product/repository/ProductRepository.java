package kr.eddi.demo.problem1319.product.repository;

import kr.eddi.demo.problem1319.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
