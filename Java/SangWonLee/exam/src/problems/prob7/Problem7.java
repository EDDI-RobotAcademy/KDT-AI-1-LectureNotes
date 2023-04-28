package problems.prob7;

import customLibrary.CustomRandom;

public class Problem7 {
    public static void main(String[] args) {

        int apple = 2000;
        float raiseMin = 3;
        float raiseMax = 20;

        float raiseApple = (float)((Math.random()* (raiseMax-raiseMin+1)+raiseMin) / 100);
        int resultApple = (int) (apple + (apple * raiseApple));

        System.out.printf("%.2f" + "%% 인상 되었습니다. \n",raiseApple);
        System.out.println("사과 가격은 : " + resultApple);


    }
}
