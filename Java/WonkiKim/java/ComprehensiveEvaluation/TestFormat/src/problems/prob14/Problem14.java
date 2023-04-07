package problems.prob14;

import customLibrary.math.RandomGenerator;

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        final int OPPORTUNITY = 7;

        RandomGenerator randomGenerator = new RandomGenerator();
        final int winNumber = randomGenerator.randomInt(3, 33);

        for(int i=0; i < OPPORTUNITY; i++) {
            Scanner sc = new Scanner(System.in);
            int playerNumber = sc.nextInt();

            if(playerNumber==winNumber) {
                System.out.println("win");
                break;
            }
            if(i==OPPORTUNITY-1) {
                System.out.println("lose");
            }

        }

    }
}
