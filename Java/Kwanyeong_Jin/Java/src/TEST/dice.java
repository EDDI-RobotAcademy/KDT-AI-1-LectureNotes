package TEST;

public class dice {
    public static void  main(String[] args ){
        final int Max = 6;
        final int Min = 1;
        final int dice1 = (int)(Math.random() * (Max - Min + 1)) + 1;
        final int dice2= (int)(Math.random() * (Max - Min + 1)) + 1;
        int dice_sum = dice1 + dice2;
            if (dice_sum % 4 == 0) {
                System.out.println("첫번째 주사위의 값은 " + dice1 + "이며");
                System.out.println("두번째 주사위의 값은 " + dice2 + "이므로");
                System.out.println("두 주사위의 합은 " + dice_sum + "이며 4의 배수가 되어 승리하였습니다.");
            }
            else {
                System.out.println("첫번째 주사위의 값은 " + dice1 + "이며");
                System.out.println("두번째 주사위의 값은 " + dice2 + "이므로");
                System.out.println("두 주사위의 합은 " + dice_sum + "이며 4의 배수가 아니므로 패배하였습니다.");
            }
    }
}
