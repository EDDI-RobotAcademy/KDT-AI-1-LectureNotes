package homework;

class Game3 {
    //굴린 주사위 점수를 기반으로 두번째 세번째까지 굴릴것인가 체크
    //2명의 굴린 주사위 점수의 총합 체크

    int firstDice;
    int secondDice;
    int thirdDice;
    //각각 주사위 세개의 나온 값
    int sumA = 0;
    //A의 총 점수
    int sumB = 0;

    boolean winA, winB = true;

    //B의 총 점수
    final Dice3 dice = new Dice3();

    public Game3() {
        firstDice = dice.getScore();
        System.out.println(firstDice);
        if (firstDice % 2 == 0) {
            secondDice = dice.getScore();
            System.out.println(secondDice);
            sumB = secondDice;
            thirdDice = dice.getScore();
            System.out.println(thirdDice);
            if (thirdDice == 1) {
                sumA += 3;
                sumB -= 3;
            }
            if (thirdDice == 3) {
                sumA += 2;
            }
            if (thirdDice == 4) {
                winA = false;
            }

        } else {
            sumA = firstDice;
        }


        if (firstDice % 2 == 0) {
            secondDice = dice.getScore();
            sumB += secondDice;
            thirdDice = dice.getScore();
            if (thirdDice == 1) {
                sumB += 3;
                sumA -= 3;
            }
            if (thirdDice == 3) {
                sumB += 2;
            }
            if (thirdDice == 4) {
                winB = false;
            }

        } else {
            sumB = firstDice;


        }

    }

    public boolean isWinA() {
        return winA;
    }

    public boolean isWinB() {
        return winB;
    }

    public int getSumA() {
        return sumA;
    }

    public int getSumB() {
        return sumB;
    }
}

class winCheck3 {
    final Game3 game = new Game3();


    public winCheck3() {
        if (game.isWinA() && game.isWinB()) {
            if (game.getSumA() > game.getSumB()) {
                System.out.println("A의 승리!");
            } else if (game.getSumA() < game.getSumB()) {
                System.out.println("B의 승리!");
            } else {
                System.out.println("무승부");
            }
        } else if (game.isWinA() && !game.isWinB()) {
            System.out.println("A의 승리!");
        } else if (!game.isWinA() && game.isWinB()) {
            System.out.println("B의 승리!");
        } else {
            System.out.println("무승부");
        }
    }


}
//승자는 누구인가 승자확인

class Dice3 {
    // 주사위를 생성후 굴리는 것까지

    final private int MAX = 6;
    private int min = 1;
    final int [] DICE_ARRAY = new int[MAX-min];

    int score;

    public Dice3() {
        //주사위를 생성
        for (int i = 0; i < (MAX-min); i++) {
            DICE_ARRAY[i] = min;
            min += 1;
        }
        //주사위를 굴리자
        score = DICE_ARRAY [(int)(Math.random()*MAX-min)+min];
    }

    public int getScore() {
        return score;
    }
}

public class ranDice3 {
    public static void main(String[] args) {
        final Game3 game = new Game3();
        final winCheck3 win = new winCheck3();


    }
}
