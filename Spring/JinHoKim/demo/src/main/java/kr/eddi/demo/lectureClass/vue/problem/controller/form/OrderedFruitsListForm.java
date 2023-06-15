package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderedFruitsListForm {
//    List<OrderedFruits> orderedFruitsList;
//
//    public OrderedFruitsListForm(List<OrderedFruits> orderedFruitsList) {
//        this.orderedFruitsList = orderedFruitsList;
//    }
    final private String appleName;
    final private Integer appleCount;
    final private String watermelonName;
    final private Integer watermelonCount;
}
