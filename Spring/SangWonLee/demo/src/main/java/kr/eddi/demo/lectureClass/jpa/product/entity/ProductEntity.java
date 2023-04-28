package kr.eddi.demo.lectureClass.jpa.product.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@ToString
@NoArgsConstructor
@Getter

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private Integer price;
    private String company;
    private LocalDate manufactureDate;
    private LocalDate expDate;
    private String category;

    public ProductEntity(String name, Integer price, String company, LocalDate manufactureDate, String category) {
        this.name = name;
        this.price = price;
        this.company = company;
        this.manufactureDate = manufactureDate;
        this.expDate = manufactureDate.plusYears(3);
        this.category = category;
    }

}
