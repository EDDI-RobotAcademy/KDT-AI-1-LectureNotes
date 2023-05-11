package com.example.demo.lectureClass.homework.d3Bank1;

import com.example.demo.lectureClass.homework.d3Bank1.exerciseGraph.ExerciseAmount;
import com.example.demo.lectureClass.homework.d3Bank1.exerciseGraph.Graph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/d3-problem")
public class D3Bank1Controller {

    @GetMapping("/getGraphInfo")
    public List<ExerciseAmount> getGraphInfo () {
        Graph graph = new Graph();
        log.info("list: " + graph.getExerciseAmountList());
        return graph.getExerciseAmountList();
    }
}
