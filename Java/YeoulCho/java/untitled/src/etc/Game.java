package etc;

public class Game {
    Player player1;
    Player player2;
    Dice1 dice1;



    public Game() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.dice1 = new Dice1();
        player1.score = 0;
        player2.score = 0;
    }

    public void playGame() {
        for (int i = 0; i < 3; i++) {
            player1.score = player1.score + dice1.randomDice();
            player2.score = player2.score + dice1.randomDice();

        }
    }

    public void checkWinner() {
        if (player1.score % 4 == 0 && player2.score %4 ==0) {
            if(player1.score > player2.score) {
                System.out.println("플레이어1의 승리");
            } else {
                System.out.println("플레이어2의 승리");
            }
        } else {
            if (player1.score % 4==0) {
                System.out.println("플레이어1의 승리");
            } else if (player2.score % 4==0){
                System.out.println("플레이어2의 승리");
            }
            else {
                System.out.println("둘다 패배");
            }
        }
    }

    // class 사용해서 주사위문제
    // 플레이어2명이 주사위3개 던지기
    // 일단 4의 배수여야 주사위총합 비교가능
    public static void main(String[] args) {
        Game game1 = new Game(); // 리턴값 있어 게임클래스.
        game1.playGame(); // 리턴값 없다.
        //game1.totalScore(); // 리턴값 없다.
        game1.checkWinner(); // 리턴값 없다.
//        Player player1 = new Player();
//        Player player2 = new Player();
//        player1.rollDice();
//        player2.rollDice();
//
//        if (player1.getDiceSum() > player2.getDiceSum()) {
//            System.out.println("승자는 플레이어1" + player1);
//        } else {
//            System.out.println("승자는 플레이어2 " + player2);
//
//        }


    }
}
