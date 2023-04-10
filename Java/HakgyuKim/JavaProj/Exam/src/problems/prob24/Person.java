package problems.prob24;

import customLibrary.CustomRandom;

public class Person {
    final private String name;
    final private int locationX;
    final private int locationY;

    public Person(String name) {
        this.name = name;
        this.locationX = CustomRandom.generateNumber(100);
        this.locationY = CustomRandom.generateNumber(100);
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                '}';
    }
}
