package com.example.demo.controller.lectureClass.vue.controller.form;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderedFruitsListForm {

    final private String appleName;
    final private Integer appleCount;
    final private String watermelonName;
    final private Integer watermelonCount;
}
