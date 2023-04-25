package com.example.demo.lectureClass.form;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

// toString() 메서드를 적는 것 자체가 매우 번거로움
// 그러므로 @ToString을 배치해서 알아서 객체 정보를 출력하도록 만들 수 있음
@ToString // 자바에서는 toString() 메서드를 만들어줬어야 했는데 여기서는 이거 하나로 퉁칠 수 있음
// final 키워드가 붙어 있는 내부 정보를
// 자동으로 초기화 해주는 것이 RequiredArgsConstructor에 해당함
// 뷰에서 post맵핑으로 보냈을 때 자동으로 초기화됨 - 자동으로 채워져서 전달이 된다는 뜻
// 데이터 처리해달라고 들어오는 시점에서 데이터 받을 필요 없으니 final 맞음
@RequiredArgsConstructor
public class VueRequestTestDataForm {

    final private String studentName;
    final private String studentMajor;
    final private Integer studentAge;
}
