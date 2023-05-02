package kr.eddi.demo.lectureClass.vue.problem3.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class BuyFruitResponseForm {
    private final Integer sumNumber;
    private final String fruitName;
}
