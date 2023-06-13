package kr.eddi.demo.lectureClass.vue.files.controller.form;

import kr.eddi.demo.lectureClass.vue.files.entity.FileTest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FileInfoRequestForm {

    final private Integer price;
    final private String productName;

    public FileTest toFileTest(String originalFileName) {
        return new FileTest(price, productName, originalFileName);
    }
}
