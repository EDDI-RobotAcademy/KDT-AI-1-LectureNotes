package kr.jinho.jinhokim.practice2.repository;

import kr.jinho.jinhokim.practice2.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Long> {
}
