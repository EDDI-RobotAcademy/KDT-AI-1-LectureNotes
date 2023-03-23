package homework;

public class Homework1 {
    public static void main(String[] args) {

        int n = 4;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("주사위" + (i + 1) + ":" + dice);
            sum += dice;
        }

        System.out.println("주사위" + n + "개의 합은" + sum);

        if (sum % 4 == 0) {
            System.out.println("승리하셨습니다");



            } else {
                System.out.println("패배하셨습니다");
            }
        }
    }



