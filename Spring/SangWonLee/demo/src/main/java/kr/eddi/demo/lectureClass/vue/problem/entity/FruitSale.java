package kr.eddi.demo.lectureClass.vue.problem.entity;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.FruitNumber;

public class FruitSale {
    private int sale;

    public FruitSale(FruitNumber fruitNumber) {
        this.sale = (int)(Math.random() * (1000-500) + 1);

    }
}
