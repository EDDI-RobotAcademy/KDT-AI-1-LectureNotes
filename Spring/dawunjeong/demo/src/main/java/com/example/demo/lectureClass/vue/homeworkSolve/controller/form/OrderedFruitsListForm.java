package com.example.demo.lectureClass.vue.homeworkSolve.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderedFruitsListForm {
    final private String appleName;
    final private Integer appleCount;
    final private String watermelonName;
    final private Integer watermelonCount;
}
