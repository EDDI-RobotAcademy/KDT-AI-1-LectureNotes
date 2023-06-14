package kr.eddi.demo.refactorProduct.repository;

import kr.eddi.demo.refactorProduct.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagesRepository extends JpaRepository<ProductImages,Long> {
}
