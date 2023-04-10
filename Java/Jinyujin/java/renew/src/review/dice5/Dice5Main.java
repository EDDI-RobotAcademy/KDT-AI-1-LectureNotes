package review.dice5;
//주사위를 3개 굴립니다.
//첫 번째 주사위가 짝수라면
//두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.
//두 번째 주사위는 특수 기능이 별도로 존재하지 않습니다.
//세 번째 주사위는 숫자 1인 경우 친구에게 점수를 3점 뺏을 수 있습니다.
//숫자가 3인 경우엔 자신에게 2점을 가산합니다.
//숫자가 4인 경우엔 무조건 패배하게 됩니다.
//친구와 함께 플레이 할 수 있는 주사위 게임을 만들어주세요.
//추가적으로 확장 - 사용자의 숫자가 더 이상 두 명이 아니고 N명으로

// 게임플레이하는 메소드에는 뭐가 필요할까?
// 플레이어들이 주사위를 굴리는게 필요할 것
// 그럼 주사위 생성 - 완료
// 플레이어 생성 - 이름
// 플레이어 수에 따라 주사위가 굴려져야 함 -> 플레이어 리스트에 주사위 숫자 넣기
public class Dice5Main {
    public static void main(String[] args) {
//        // 게임객체() 생성
//        Game5 game = new Game5();
//        // 게임을 플레이하는 메소드를 만들어놓자
//        game.gamePlay();
//        // 승자 판정하는 메소드를 만들어놓자
//        game.checkWin();

//        Player5 player5 = new Player5("");
//        System.out.println(player5);
//
        Game5 game5 = new Game5();
        System.out.println(game5);
    }
}