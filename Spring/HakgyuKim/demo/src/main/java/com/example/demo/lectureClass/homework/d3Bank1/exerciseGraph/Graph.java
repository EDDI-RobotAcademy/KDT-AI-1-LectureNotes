package com.example.demo.lectureClass.homework.d3Bank1.exerciseGraph;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Graph {
    final private List<ExerciseAmount> exerciseAmountList;

    final private int EXERCISE_AMOUNT_NUM = 7;
    private String startDate;
    public Graph () {
        exerciseAmountList = new ArrayList<>();
        for (int i = 0; i < EXERCISE_AMOUNT_NUM; i++) {
            exerciseAmountList.add(new ExerciseAmount((i+1) + "-May-23"));
        }
    }
}
