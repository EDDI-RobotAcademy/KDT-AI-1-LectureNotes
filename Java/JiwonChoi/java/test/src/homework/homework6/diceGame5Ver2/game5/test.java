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

        System.out.println(Game.getPlayerList().get(0));
        System.out.println(Game.getPlayerList().get(1));
        System.out.println(Game.getPlayerList().get(2));
        System.out.println(Game.getPlayerList().get(3));

        System.out.println(Target.findTargetPlayer(Game.getPlayerList().get(0)));




    }
}
