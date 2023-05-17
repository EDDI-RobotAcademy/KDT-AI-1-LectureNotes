package com.example.demo.lectureClass.vue.files.controller.form;

import com.example.demo.lectureClass.vue.files.entity.FileTest;
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
        // originalFileName까지 포함해서 리턴해라
        // originalFileName은 받아올 게 없으니 선언해줄 수 없고
        // 여기서 매개변수로 만들어서 FileTest에 반환해주는 것
        // Entity 클래스에서 만들어주면 안될까?
        // 안되지 홈페이지에서 입력하면 받아와서 저장되는 거니까
    }
}
