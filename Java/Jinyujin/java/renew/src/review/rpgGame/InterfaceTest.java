package review.rpgGame;

public class InterfaceTest {
    // 게임을 구현하도록 하자
    // 캐릭터가 있고 몬스터가 있음
    // 각각 클래스 생성
    // 캐릭터와 몬스터가 대결하는 RPGgame

    public static void main(String[] args) throws InterruptedException {
        RpgGame rpgGame = new RpgGame();
        System.out.println(rpgGame);

        rpgGame.playGame();
        System.out.println(rpgGame); // 끝나고 몬스터 상태 보여주는 리스트를 나타내줌
    }
}
