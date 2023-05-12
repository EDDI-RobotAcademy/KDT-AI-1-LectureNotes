package practice.dice2.dice2Replay;
// 주사위 4개 -> 주사위부터 만들자
// 이제 4개 굴려야 해
// 근데 주사위를 굴리는건 게임하는 클래스에서 하는게 좋을 듯? - 완료
// 이제 합산값에 대한 판정이 필요해
// 그럼 판정 클래스로 이동해보자
// 판정 클래스에서 만들었음
// 이제 이걸 다시 게임 클래스로 가져와서 판정하자

public class Dice2ReMain {
    public static void main(String[] args) {
        GameRe game = new GameRe();
        game.rollDice();
        game.lastJudgement();
    }
}
