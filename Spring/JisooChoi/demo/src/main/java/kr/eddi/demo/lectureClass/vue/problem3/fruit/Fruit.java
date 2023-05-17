package kr.eddi.demo.lectureClass.vue.problem3.fruit;

public class Fruit {
    Apple apple = new Apple();
    WaterMelon waterMelon = new WaterMelon();

    public Fruit() {
    }

    public Apple getApple() {
        return apple;
    }

    public WaterMelon getWaterMelon() {
        return waterMelon;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "apple=" + apple +
                ", waterMelon=" + waterMelon +
                '}';
    }
}
