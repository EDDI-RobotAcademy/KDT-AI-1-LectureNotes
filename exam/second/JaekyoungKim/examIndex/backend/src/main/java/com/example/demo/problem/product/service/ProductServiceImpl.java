package com.example.demo.problem.product.service;

import com.example.demo.problem.product.controller.form.ProductReadResponseForm;
import com.example.demo.problem.product.entity.Product;
import com.example.demo.problem.product.entity.ProductImages;
import com.example.demo.problem.product.repository.ProductImagesRepository;
import com.example.demo.problem.product.repository.ProductRepository;
import com.example.demo.problem.product.service.request.ProductRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;
    final private ProductImagesRepository productImagesRepository;

    @Override
    public Boolean register(ProductRegisterRequest request, List<MultipartFile> imageFileList) {

        final List<ProductImages> productImagesList = new ArrayList<>();
        final String fixedDirectoryPath = "../frontend/src/assets/uploadImgs/";

        Product product = request.toProduct();

        try {
            for (MultipartFile multipartFile: imageFileList) {
                final String originalFileName = multipartFile.getOriginalFilename();
                final String uniqueRandomFileName = UUID.randomUUID() + originalFileName;
                final String fullPath = fixedDirectoryPath + uniqueRandomFileName;
                final FileOutputStream writer = new FileOutputStream(fullPath);

                log.info("originalFileName: " + originalFileName);

                writer.write(multipartFile.getBytes());
                writer.close();

                ProductImages productImages = new ProductImages(uniqueRandomFileName);
                productImagesList.add(productImages);

                product.setProductImages(productImages);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        productRepository.save(product);
        productImagesRepository.saveAll(productImagesList);

        return true;
    }

    @Override
    public ProductReadResponseForm read(Long productId) {
        final Optional<Product> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            return null;
        }
        final Product product = maybeProduct.get();

        final List<ProductImages> productImagesList =
                productImagesRepository.findImagePathByProductId(productId);

        log.info("productImagesList: " + productImagesList);

        return new ProductReadResponseForm(product, productImagesList);
    }
}
