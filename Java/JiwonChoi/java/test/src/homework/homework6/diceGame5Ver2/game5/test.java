package homework.homework6.diceGame5Ver2.game5;

public class test {
    public static void main(String[] args) {

        new Game();
        Game.playerAdd("김미미");
        Game.playerAdd("이쥬쥬");
        Game.playerAdd("박콩순");
        Game.playerAdd("최라라");

        Game.rollThreeDices(Game.getPlayerList());
        Game.sumDices(Game.getPlayerList());

        for (int i = 0 ; i < Game.playerList.size();i++) {
            Game.findTargetPlayer(Game.getPlayerList().get(i));
        }

        Game.finalScore();

        for (int i = 0 ; i < Game.playerList.size();i++) {
            System.out.println(Game.getPlayerList().get(i));
        }

        Game.winnerCheck();


    }
}
