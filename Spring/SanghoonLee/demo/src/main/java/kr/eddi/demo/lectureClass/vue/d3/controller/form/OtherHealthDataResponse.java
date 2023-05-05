package kr.eddi.demo.lectureClass.vue.d3.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class OtherHealthDataResponse {
    final private Integer healthAmount;
    final private LocalDate date;
}
