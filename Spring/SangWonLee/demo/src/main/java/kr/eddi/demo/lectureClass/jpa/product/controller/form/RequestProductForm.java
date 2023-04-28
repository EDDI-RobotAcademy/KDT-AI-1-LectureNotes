package kr.eddi.demo.lectureClass.jpa.product.controller.form;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.product.entity.ProductEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@RequiredArgsConstructor

public class RequestProductForm {
    private String name;
    private Integer price;
    private String company;
    private LocalDate manufactureDate;

    private String category;

    public ProductEntity toProductEntity(){

        return new ProductEntity(name,price,company,manufactureDate,category);
    }

}
