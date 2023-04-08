package customLibrary.pb7;

import customLibrary.math.RandomGenerator;

public class Apple {
    final private int standardPrice = 2000;
    final private float MINRATE = -0.03f;
    final private float MAXRATE = 0.20f;
    final private float price;

    public Apple() {
        RandomGenerator randomGenerator = new RandomGenerator();
        price = randomGenerator.randomFloat(standardPrice * (1 + MINRATE), standardPrice * (1 + MAXRATE));

    }

    public int getPrice() {
        return (int) price;
    }
}
