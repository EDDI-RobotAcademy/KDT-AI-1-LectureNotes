package problems.prob15;

import java.util.ArrayList;

public class Problem15 {
    public static void main(String[] args) {
        ArrayList<Integer> plusNumSecond = new ArrayList<>();

        final int CONDITION_NUM = 1000;

        for(int i = 1; i < CONDITION_NUM; i+=2){
            plusNumSecond.add(i);
        }
        System.out.println(plusNumSecond.get(273));
    }
}
