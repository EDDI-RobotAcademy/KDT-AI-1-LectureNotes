package com.example.demo.lectureClass.homework.bank6.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@NoArgsConstructor
@ToString
public class ImageNameForm {
    private String imageName;

    public ImageNameForm(String imageName) {
        this.imageName = imageName;
    }
}
