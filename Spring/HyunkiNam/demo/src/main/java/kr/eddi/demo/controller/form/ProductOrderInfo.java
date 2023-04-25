package kr.eddi.demo.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ProductOrderInfo {
    final private int orderNumber;
    final private String customerName;
    final private String customerAddress;
    final private String customerPhoneNumber;
    final private int totalPrice;
}
