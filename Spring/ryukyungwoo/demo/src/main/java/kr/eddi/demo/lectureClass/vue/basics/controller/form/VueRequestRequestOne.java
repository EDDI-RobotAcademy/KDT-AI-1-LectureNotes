package kr.eddi.demo.lectureClass.vue.basics.controller.form;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
// 데이터 1개 보내는 경우엔 아래와 같이 NoArgsConstructor 구성이 필요함
// 현존하는 프레임워크 버그라 봐도 무방함
@NoArgsConstructor
public class VueRequestRequestOne {
    private Integer studentAge;

    public VueRequestRequestOne(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
