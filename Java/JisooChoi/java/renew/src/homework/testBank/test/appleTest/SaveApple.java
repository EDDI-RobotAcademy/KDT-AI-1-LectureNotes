package homework.testBank.test.appleTest;

import utility.random.CustomRandom;
import java.util.ArrayList;

public class SaveApple {
    private int appleRandom;
    private int appleSumPrice;
    final private ArrayList<Integer> appleList = new ArrayList<>();

    public void getApple(){
        final int APPLE_MAX_NUM = 5;
        final int APPLE_MIN_NUM = 3;
        final int APPLE_MAX_COST = 10000;
        final int APPLE_MIN_COST = 5000;

        appleRandom = CustomRandom.generateNumber(APPLE_MIN_NUM, APPLE_MAX_NUM);

        for(int i = 0; i < appleRandom; i++){
            appleList.add(CustomRandom.generateNumber(APPLE_MIN_COST, APPLE_MAX_COST));
            appleSumPrice += appleList.get(i);
        }
    }

    @Override
    public String toString() {
        return "SaveApple{" +
                "appleRandom=" + appleRandom +
                ", appleSumPrice=" + appleSumPrice +
                ", appleList=" + appleList +
                '}';
    }
}