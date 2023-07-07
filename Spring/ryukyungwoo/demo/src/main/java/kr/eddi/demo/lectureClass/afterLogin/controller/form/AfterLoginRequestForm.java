package kr.eddi.demo.lectureClass.afterLogin.controller.form;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AfterLoginRequestForm {

    private String userToken;
    private Integer testNumber;



}