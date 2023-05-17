package kr.eddi.demo.lectureClass.jpa.board.controller.form;

import lombok.Getter;

@Getter
public class D3PlotResponse {
    final private String date;
    final private Integer momentum;

    public D3PlotResponse(String date, Integer momentum) {
        this.date = date;
        this.momentum = momentum;
    }
}
