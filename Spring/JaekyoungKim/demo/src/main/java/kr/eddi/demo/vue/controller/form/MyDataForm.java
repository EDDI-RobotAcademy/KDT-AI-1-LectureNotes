package kr.eddi.demo.vue.controller.form;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class MyDataForm {
    private Integer studentGrade;

    public MyDataForm(Integer studentGrade) {
        this.studentGrade = studentGrade;
    }
}
