package com.example.demo.lectureClass.vue.files.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ImagePathResponseForm {
    final private String imagePath;
    // 스프링 입장에서 request는 이렇게 받을게요
    // response는 이렇게 줄게요
    // 지금은 imagePath만 보내기 위해서 폼을 따로 만들어준 것
}
