public class dice {

    public static void main(String[] args) {
        int dice1;
        int dice2;

        for (int i = 0; i <= 10; i++) {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            if ((dice1 + dice2) % 12 == 0) {
                System.out.print(dice1 + dice2);
                System.out.println(" 12가 나오셨군요 - 대박승리!");
            } else if ((dice1 + dice2) % 4 == 0) {
                System.out.print(dice1 + dice2);
                System.out.println(" - 4의 배수 - 승리!");
            } else if ((dice1 + dice2) % 3 == 0) {
                System.out.print(dice1 + dice2);
                System.out.println(" - 3의 배수 - 대박!");
            } else {
                System.out.print(dice1 + dice2);
                System.out.println(" - 패배 -");
            }
        }
    }
}
