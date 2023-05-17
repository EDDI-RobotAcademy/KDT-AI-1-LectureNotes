package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.service;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.controller.form.TestPracticeProductRequestForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.entity.TestPracticeProduct;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.repository.TestPracticeProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestPracticeProductServiceImpl implements TestPracticeProductService{

    @Autowired
    private TestPracticeProductRepository testPracticeProductRepository;

    @Override
    public TestPracticeProduct register(TestPracticeProductRequestForm requestForm){
        /*
            상품 등록을 하려면
            우선 해당 상품이 repository 에 존재하는 지 확인한다.
            존재하지 않는다면, 상품 등록 과정을 거친다.
         */
        final Optional<TestPracticeProduct> practiceProduct =
                testPracticeProductRepository.findByProductName(requestForm.getProductName());

        if(practiceProduct.isPresent()){
            log.debug("동일한 상품 존재, 상품 등록 실패");
            return null;
        }

        log.debug("상품 등록 성공 !");
        return testPracticeProductRepository.save(requestForm.toTestProduct());
    }
}
