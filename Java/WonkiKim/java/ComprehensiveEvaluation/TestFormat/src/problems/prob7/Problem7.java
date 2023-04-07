package problems.prob7;

import customLibrary.math.RandomGenerator;

class Apple {
    final private int standardPrice = 2000;
    final private float MINRATE = -0.03f;
    final private float MAXRATE = 0.20f;
    final private float price;
    public Apple() {
        RandomGenerator randomGenerator = new RandomGenerator();
        price = randomGenerator.randomFloat(standardPrice * (1 + MINRATE), standardPrice * (1+MAXRATE));

    }
    public int getPrice() {
        return (int)price;
    }
}

public class Problem7 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.getPrice());
    }
}
