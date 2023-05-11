package com.example.demo.lectureClass.homework.problem.d3problem;

import com.example.demo.lectureClass.homework.problem.problem4.teacher.entity.Account;
import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/d3problem")
public class D3problemController {
    exerciseListForm exerciseListForm;
    List<exerciseListForm> exerciseList =new ArrayList<>();
    @GetMapping("/exercise")
    public List<exerciseListForm> exercise(){
        exerciseList.clear();
        exerciseList.add(new exerciseListForm());
        exerciseList.add(new exerciseListForm());
        exerciseList.add(new exerciseListForm());
        exerciseList.add(new exerciseListForm());
        exerciseList.add(new exerciseListForm());
        exerciseList.add(new exerciseListForm());
        exerciseList.add(new exerciseListForm());

        return exerciseList;
    }
}
