package kr.eddi.demo.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class BuyListDataForm {
    final private Integer apple;
    final private Integer watermelon;
    final private Integer buyPriceSum;
}
