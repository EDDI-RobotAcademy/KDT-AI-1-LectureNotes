package problems.prob20;

import java.util.Random;

public class PrintRandomNumber {

    public void makeRandomeNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        System.out.println(random.nextInt());
    }
}
