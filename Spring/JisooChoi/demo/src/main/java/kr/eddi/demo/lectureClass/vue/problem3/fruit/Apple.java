package kr.eddi.demo.lectureClass.vue.problem3.fruit;

public class Apple {
    final private int cost;
    final private int num;
    final private String name;

    public Apple() {
        this.cost = 2000;
        this.num = 3;
        this.name = "사과";
    }

    public int appleBuyCost(){
        return this.cost * this.num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "cost=" + cost +
                ", num=" + num +
                '}';
    }
}
