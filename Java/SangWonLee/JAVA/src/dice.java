public class dice {

    public static void main(String[] args) {
        int dice1; // 첫번째 주사위
        int dice2; // 두번째 주사위

        for (int i = 0; i <= 10; i++) { // 10번 반복
            dice1 = (int) (Math.random() * 6 + 1); // 1 ~ 6까지의 수 랜덤 지정
            dice2 = (int) (Math.random() * 6 + 1); // 1 ~ 6까지의 수 랜덤 지정
            if ((dice1 + dice2) % 12 == 0) {  // 두개의 합이 12라면
                System.out.print(dice1 + dice2);
                System.out.println(" 12가 나오셨군요 - 대박승리!");
            } else if ((dice1 + dice2) % 4 == 0) { // 두개의 합이 4의배수라면
                System.out.print(dice1 + dice2);
                System.out.println(" - 4의 배수 - 승리!");
            } else if ((dice1 + dice2) % 3 == 0) { // 두개의 합이 3의 배수라면
                System.out.print(dice1 + dice2);
                System.out.println(" - 3의 배수 - 대박!");
            } else { // 그 외의 것이라면
                System.out.print(dice1 + dice2);
                System.out.println(" - 패배 -");
            }
        }
    }
}
/*
결과
5 - 패배 -
10 - 패배 -
9 - 3의 배수 - 대박!
3 - 3의 배수 - 대박!
7 - 패배 -
11 - 패배 -
3 - 3의 배수 - 대박!
8 - 4의 배수 - 승리!
5 - 패배 -
9 - 3의 배수 - 대박!
8 - 4의 배수 - 승리!
 */
