package homework.first;

public class RandomDIce {
    public static void main(String[] args) {


        int Dice1 = (int) (Math.random() * 6) + 1;
        int Dice2 = (int) (Math.random() * 6) + 1;
        System.out.println("1번째 주사위" + Dice1);
        System.out.println("2번째 주사위" + Dice2);


        if ((Dice1 + Dice2) % 4 == 0) {
            System.out.println("주사위의 합이 4의 배수이므로 승리");
        } else {
            System.out.println("주사위의 합이 4의 배수가 아니므로 패배");
        }
    }
}