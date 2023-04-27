package kr.eddi.demo.lectureClass.jpa.product.controller;


import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductProblemController {

    ProductService productService;

    @PostMapping("/register")
    public JpaBoard registerProduct(@RequestBody RequestBoardForm requestBoardForm){
        log.info("registerProduct()");

        return productService.register(requestBoardForm.toJpaBoard());
    }


}
