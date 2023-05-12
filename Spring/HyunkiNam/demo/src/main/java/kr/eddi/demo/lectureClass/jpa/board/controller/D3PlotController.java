package kr.eddi.demo.lectureClass.jpa.board.controller;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.D3PlotResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/d3plot")
public class D3PlotController {

    private int WEEK = 7;
    private List<D3PlotResponse> d3PlotResponseList = new ArrayList<>();
    private int MIN = 0;
    private int MAX = 100;

    @GetMapping("/get")
    public List<D3PlotResponse> getMomentum(){
        d3PlotResponseList.clear();

        for(int i=0; i<WEEK; i++){
            d3PlotResponseList.add(
                    new D3PlotResponse( (i+1)+"-05-23",(int)(Math.random() * (MAX-MIN+1)) + MIN));
        }
        return d3PlotResponseList;
    }
}
