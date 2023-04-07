package homework.homework7.randomApple.classVersion;

import java.util.ArrayList;

public class RandomAppleTest {

    public static void main(String[] args) {
        RandomApple takeApple1 = new RandomApple();
        ArrayList<Integer> takeApple1List = takeApple1.takeApplesAndCost();
        takeApple1.applesCostSum(takeApple1List);

    }

}
