package practice.practice2;
// 주사위 4개 굴려서 합이 3 혹은 4의 배수가 된다면 승리 그 외는 패배
// 주사위 있어야 하고
// 4개 굴려야 하고
// 4개 합산해야 하고
// 합이 3 혹은 4의 배수가 되는지 확인
// 주사위 굴리기

public class SecondDiceGame {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        game.checkWin();
    }
}
