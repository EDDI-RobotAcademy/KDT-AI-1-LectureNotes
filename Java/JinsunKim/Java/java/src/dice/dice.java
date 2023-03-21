package dice;

public class dice {
    public static void main(String[] args) {

        final int NUM = 2;

        int sum = 0;

        for (int i = 0; i < NUM; i++) {
            int randomNumber = (int)(Math.random() * 6) +1;
            sum += randomNumber;
        }
        System.out.println(sum);


        if (sum % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }

    }


}
