package homework.homework6.diceGame5Ver2.game5;

public class test {
    public static void main(String[] args) {

        new game();
        game.playerAdd("김미미");
        game.playerAdd("이쥬쥬");
        game.playerAdd("박콩순");
        game.playerAdd("최라라");

        game.rollThreeDices(game.getPlayerList());
        game.sumDices(game.getPlayerList());

        System.out.println(game.getPlayerList().get(0));
        System.out.println(game.getPlayerList().get(1));
        System.out.println(game.getPlayerList().get(2));
        System.out.println(game.getPlayerList().get(3));



    }
}
