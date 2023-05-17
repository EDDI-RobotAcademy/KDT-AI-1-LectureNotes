package com.example.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



@Getter
@ToString
@RequiredArgsConstructor
public class OrderedFruitsListForm {
    // List<OrderedFruits> orderedFruitsList;
    //
    // public OrderedFruitsListForm(List<OrderedFruits> orderedFruitsList) {
    // this.orderedFruitsList = orderedFruitsList;
    // }
    final private String appleName;
    final private Integer appleCount;
    final private String watermelonName;
    final private Integer watermelonCount;
}
