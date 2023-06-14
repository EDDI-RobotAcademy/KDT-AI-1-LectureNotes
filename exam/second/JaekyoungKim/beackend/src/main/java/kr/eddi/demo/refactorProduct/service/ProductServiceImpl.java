package kr.eddi.demo.refactorProduct.service;

import kr.eddi.demo.refactorProduct.entity.Product;
import kr.eddi.demo.refactorProduct.entity.ProductImages;
import kr.eddi.demo.refactorProduct.repository.ProductImagesRepository;
import kr.eddi.demo.refactorProduct.repository.ProductRepository;
import kr.eddi.demo.refactorProduct.service.request.ProductRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;
    final private ProductImagesRepository productImagesRepository;
    @Override
    public Boolean register(ProductRegisterRequest productRegisterRequest, List<MultipartFile> multipartFiles) {
       final List<ProductImages> productImagesList=new ArrayList<>();
       final String fixedDirectoryPath ="../frontend/src/assets/uploadImgs/";
        Product product=productRegisterRequest.toProduct();

        try{
            for (MultipartFile multipartFile:multipartFiles){
                final String originalFileName= multipartFile.getOriginalFilename();
                final String uniqueRandomFileName= UUID.randomUUID()+originalFileName;
                final String fullPath = fixedDirectoryPath+uniqueRandomFileName;
                final FileOutputStream writer=new FileOutputStream(fullPath);
                log.info("originalFileName: "+originalFileName);

                writer.write(multipartFile.getBytes());
                writer.close();
                ProductImages productImages = new ProductImages(uniqueRandomFileName);
                productImagesList.add(productImages);

                product.setProductImages(productImages);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        productRepository.save(product);
        productImagesRepository.saveAll(productImagesList);
        return true;
    }

}
