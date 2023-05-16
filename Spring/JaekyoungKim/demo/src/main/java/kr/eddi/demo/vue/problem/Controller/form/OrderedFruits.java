package kr.eddi.demo.vue.problem.Controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderedFruits {
    final private String name;
    final private Integer min;
}