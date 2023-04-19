package kr.eddi.demo.lectureClass.vue.problem3.fruit;

public class WaterMelon {
    final private int cost;
    final private int num;
    final private String name;

    public WaterMelon() {
        this.cost = 10000;
        this.num = 5;
        this.name = "수박";
    }

    public int waterMelonBuyCost(){
        return this.cost * this.num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WaterMelon{" +
                "cost=" + cost +
                ", num=" + num +
                '}';
    }
}
