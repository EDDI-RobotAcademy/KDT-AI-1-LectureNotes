package com.example.demo.lectureClass.homework.d3Bank1.exerciseGraph;

import com.example.demo.lectureClass.utility.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ExerciseAmount {

    final private int exerciseAmount;
    final private String date;

    final private int EXERCISE_MIN = 0;
    final private int EXERCISE_MAX = 100;

    public ExerciseAmount(String date) {
        this.exerciseAmount = CustomRandom.generateNumber(EXERCISE_MIN, EXERCISE_MAX);
        this.date = date;
    }
}
