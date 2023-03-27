package HomeWork;

public class dice {

    public static void main(String[] args) {

        final int number = 2; // 주사위 갯수
        final int first_Win = 12; // 첫번째 승리 조건
        final int second_Win = 4; // 두번째 승리 조건
        final int third_Win = 3; // 세번째 승리 조건


        for (int i = 0; i <= 10; i++) { // 10번 반복

            int diceSum = 0; // 시작 전 주사위 합 초기화

            for (int j = 0; j < number; j++) { // 주사위 갯수만큼 반복
                final int dice = (int) (Math.random() * 6 + 1); // 1 ~ 6까지의 수 랜덤 지정
                diceSum += dice; // 주사위 합에 추가
            }

            if ((diceSum) % first_Win == 0) {  // 두개의 합이 12라면
                System.out.print(diceSum);
                System.out.println(" - 12가 나오셨군요 - 대박승리!");
            } else if ((diceSum) % second_Win == 0) { // 두개의 합이 4의배수라면
                System.out.print(diceSum);
                System.out.println(" - 4의 배수 - 승리!");
            } else if ((diceSum) % third_Win == 0) { // 두개의 합이 3의 배수라면
                System.out.print(diceSum);
                System.out.println(" - 3의 배수 - 대박!");
            } else { // 그 외의 것이라면
                System.out.print(diceSum);
            }
        }
    }
}

/*

결과

8 - 4의 배수 - 승리!
9 - 3의 배수 - 대박!
6 - 3의 배수 - 대박!
5 - 패배 -
5 - 패배 -
7 - 패배 -
4 - 4의 배수 - 승리!
5 - 패배 -
7 - 패배 -
3 - 3의 배수 - 대박!
12 - 12가 나오셨군요 - 대박승리!

 */