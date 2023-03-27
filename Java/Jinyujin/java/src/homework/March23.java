package homework;

import utility.random.CustomRandom;

public class March23 {
    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 6;
        final int MAX_DICE_NUMBER = 3;

        int[] diceArrayNumber = new int[MAX_DICE_NUMBER];

        // 주사위 굴리기
//        int dice1 = (int)CustomRandom.generateNumber(MIN,MAX);
//        int dice2 = (int)CustomRandom.generateNumber(MIN,MAX);
//        int dice3 = (int)CustomRandom.generateNumber(MIN,MAX);

        // 배열로 합쳐서 정리
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceArrayNumber[i] = CustomRandom.generateNumber(MIN, MAX);
        }

        // 처음에는 diceFace를 만들었으나 주사위 3개의 결과가 다 같게 나옴
        // -> 배열을 만들었으니 배열을 이용하자
        // 첫 번째 주사위 짝수면 다음 턴 가능
        if (diceArrayNumber[0] % 2 == 0) {
            System.out.println("첫 번째 주사위는 짝수 -> 게임 계속");
            System.out.println("두 번째 주사위의 수는 " + diceArrayNumber[1]);
            System.out.println("세 번째 주사위의 수는 " + diceArrayNumber[2]);

            // 두번째 주사위는 특수 기능 X

            // 세 번째 주사위는 숫자 1이 나오면 친구에게 점수 3점 뺏음
            //               숫자 3이 나오면 자신에게 2점
            //               숫자 4가 나오면 무조건 패배
            if (diceArrayNumber[2] == 1) {
                System.out.println("3점을 뺏습니다");
            } else if (diceArrayNumber[2] == 3) {
                System.out.println("2점을 뺏겼습니다");
            } else if (diceArrayNumber[2] == 4) {
                System.out.println("패배. 게임을 끝냅니다");
            } else {
                System.out.println("아무 일 일어나지 않습니다");
            }
        } else {
            System.out.println("첫 번째 주사위는 홀수 -> 게임 종료");
        }
    }
}


//            if (diceArrayNumber[2] == 1) {
//                System.out.println("3점을 뺏습니다");
//            }
//            //               숫자 3이 나오면 자신에게 2점 뺌
//            if (diceArrayNumber[2] == 3) {
//                System.out.println("2점을 뺏겼습니다");
//            }
//            //               숫자 4가 나오면 무조건 패배
//            if (diceArrayNumber[2] == 4) {
//                System.out.println("패배. 게임을 끝냅니다");
//            } else {
//                System.out.println("아무 일 일어나지 않았습니다");
//            } else{
//                System.out.println("첫 번째 주사위는 홀수 -> 게임 종료");
//            }
            // 가독성 좋게 하려고 했으나 중복되어 출력됨
            // 마지막에서 두번째 else는 마지막 if만 인식하여 else if로 고치니 성공





