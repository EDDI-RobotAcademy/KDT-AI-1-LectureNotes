package TEST;

public class dice_Uebung {
    public static void  main(String[] args ){
        final int MAX = 6;
        final int MIN = 1;
        final int dice1 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        final int dice2 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        final int dice_sum = dice1 + dice2;
        final int MULTIPLE = 4;
        if(dice_sum % MULTIPLE == 0) {
                System.out.println("첫번째 주사위의 값은 " + dice1 + "이며 두번째 주사위의 값은 " + dice2 + "이므로");
                System.out.println("두 주사위의 합은 " + dice_sum + "이며 4의 배수가 되어 승리하였습니다.");
            }
        else {
                System.out.println("첫번째 주사위의 값은 " + dice1 + "이며 두번째 주사위의 값은 " + dice2 + "이므로");
                System.out.println("두 주사위의 합은 " + dice_sum + "이며 4의 배수가 아니므로 패배하였습니다.");
            }
    }
}
