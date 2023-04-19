package kr.eddi.demo.vue.controller.form;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
// toString() 메서드를 적는 것 자체가 매우 번거로운 일임
// 그러므로 @ToString 을 배치해서 알아서 객체 정보를 출력하도록 만들 수 있음
@ToString
//final 키워드가 붙어 있는 내부 정보를
// 자동으로 초기화 해주는 것이 RequireArgsConstructor 에 해당함
@RequiredArgsConstructor
public class VueRequestTestDataForm {

    final private String studentName;
    final private String studentMajor;
    final private Integer numberA;

    public Integer getNumberA() {
        return numberA;
    }
}