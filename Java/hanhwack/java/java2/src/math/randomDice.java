package math;

public class randomDice {
    public static void main(String[] args) {

        int sum = 0;
        final int MAX = 6;
        int randomValue = 0;
        final int diceNum = 2;

        for(int i = 1; i <= diceNum; i++) {
            randomValue = (int)(Math.random() * MAX) + 1;
            sum += randomValue;
        }

        System.out.println("주사위 " + diceNum+" 개의 합은 " +sum);

        switch (sum) {
            case 4:
                System.out.println("승리!!!!");
                break;

            case 8:
                System.out.println("승리!!!");
                break;

            case 12:
                System.out.println("승리!!!");
                break;

                default:
                System.out.println("패배");
                break;

        }
    }

}
