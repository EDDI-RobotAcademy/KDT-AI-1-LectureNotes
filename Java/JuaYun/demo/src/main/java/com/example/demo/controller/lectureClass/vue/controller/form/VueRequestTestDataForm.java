package com.example.demo.controller.lectureClass.vue.controller.form;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

// alt insert해서 불러온 ToString을 퉁칠수 있음
// ToString() 매서드를 적는 것 자체가 매우 번거로움
// 그러므로 @ToString을 배치해서 알아서 객체 정보를 출력하도록 만들 수 있음
@ToString
// final 키워드가 붙어 있는 내부 정보를
// 지동으로 초기화 해주는 것이 RequiredArgsConstructor 에 해당함
@RequiredArgsConstructor
public class VueRequestTestDataForm {

    // 이름이 동일하게 맞춰줘야함
    final private String studentName;
    final private String studentMajor;
    final private Integer studentAge;
}
