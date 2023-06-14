package kr.eddi.demo.lectureClass.vue.basics.controller.form;

//import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// toString() 메서드를 적은 것 자체가 매우 번거로움
// 그러므로 @ToString을 배치해서 알아서 객체 정보를 출력하도록 만들 수 있음
@ToString
// final 키워드가 붙어 있는 내부 정보를 자동으로 초기화 해주는 것이 RequireArgsConstructor에 해당함
@RequiredArgsConstructor
// 데이터 1개 보내는 경우엔 아래와 같이 @NoArgsConstructor 구성이 필요함
// 현존하는 프레임워크 버그라 봐도 무방함
//@NoArgsConstructor
public class VueRequestTestDataForm {

    final private String studentName;
    final private String studentMajor;
    final private Integer studentAge;
}