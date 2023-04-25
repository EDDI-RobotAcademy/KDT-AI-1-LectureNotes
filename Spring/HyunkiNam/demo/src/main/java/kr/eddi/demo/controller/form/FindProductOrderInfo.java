package kr.eddi.demo.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class FindProductOrderInfo {
    private Integer findOrderInfoNumber;

    public FindProductOrderInfo(Integer findOrderInfoNumber) {
        this.findOrderInfoNumber = findOrderInfoNumber;
    }
}
