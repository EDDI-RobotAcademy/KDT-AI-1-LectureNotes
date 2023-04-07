package review1.yujin;

public class FirstDiceGameReview2 {
    public static void main(String[] args) {
        // 1. Game 클래스 만들기
        // 2. Game 클래스 내부에 주사위 리스트가 있음
        // 3. Player 클래스가 주사위 리스트 주입바도록 만든다.
        // * 일단 좀 힘드니까 쉬었다 합시다.

        ReviewGame2 game = new ReviewGame2();
        System.out.println(game);

        // game.Score() 형식은 game내에 Score()라는 매서드가 필요합니다.
        // game.Score();
        // 그리고 보통 매서드의 첫 시작은 소문자로 만들기 때문에
        // game.score()라고 표현하는 것이 좋습니다.
        game.checkWin();
    }
}
