package kr.eddi.demo.lectureClass.vue.files.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FileInfoRequestForm {

    final private Integer price;
    final private String productName;
}