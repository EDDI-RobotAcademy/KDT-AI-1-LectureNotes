package Basic_Grammar;

public class Random_Test {
    public static void main(String[] args) {
        final int randomNumber = (int)(Math.random() * 100) + 1;
        final int START = 0;
        final int END = 100;
        final int TEXT_MAX = 77;
        final int MAX = 15;
        final int MIN = 5;

        System.out.println("randomNumber = " + randomNumber);

        int randomValue = 0;

        for(int i = START; i < END; i++) {
            randomValue = (int) (Math.random()*100 +1); // 1 ~ 77
            System.out.println("i  = " + i +", randomValue = " + randomValue);
        } // i  = 64, randomValue = 27 // 중간에 하나만 가져왔음

        System.out.println();

        for (int i = START; i < END; i++){
            randomValue = (int) (Math.random() * (MAX - MIN + 1)) + MIN; // 5 ~ 15
            System.out.println("i = " + i + ", randomValue = " + randomValue);
        } // i = 38, randomValue = 7 // 중간에 하나만 가져왔음
    }

}
