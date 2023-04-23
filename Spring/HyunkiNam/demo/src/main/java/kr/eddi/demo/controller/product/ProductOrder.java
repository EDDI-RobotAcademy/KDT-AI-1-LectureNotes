package kr.eddi.demo.controller.product;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductOrder {
    final int orderNumber;
    final String customerName;
    final String customerAddress;
    final String customerPhoneNumber;
    final int totalPrice;

    public ProductOrder(int orderNumber, String customerName, String customerAddress, String customerPhoneNumber, int totalPrice) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.totalPrice = totalPrice;
    }
}
