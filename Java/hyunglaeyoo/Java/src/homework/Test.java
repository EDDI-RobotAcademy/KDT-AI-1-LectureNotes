package homework;

class Dice {

    final int DICE_MIN = 1;
    final int DICE_MAX = 6;
    final int DICE_NUMBER = (int)(Math.random() * (DICE_MAX - DICE_MIN + 1)) + DICE_MIN;
    public Dice () {
    }

    public int getDICE_NUMBER() {
        return  DICE_NUMBER;
    }
}

public class Test{
    public static void main(String[] args) {
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();

        final int DICE_SUM = d1.getDICE_NUMBER() + d2.getDICE_NUMBER() +
                d3.getDICE_NUMBER() + d4.getDICE_NUMBER();

        final int GAME_WINNER1 = 4;
        final int GAME_WINNER2 = 3;

        System.out.println("DICE1: " + d1.getDICE_NUMBER() );
        System.out.println("DICE2: " + d2.getDICE_NUMBER() );
        System.out.println("DICE3: " + d3.getDICE_NUMBER() );
        System.out.println("DICE4: " + d4.getDICE_NUMBER() );
        System.out.println("총합:" + DICE_SUM );

        if (DICE_SUM % GAME_WINNER1 == 0 ||DICE_SUM % GAME_WINNER2 == 0 )
             {System.out.println("승리");
        }
        else {System.out.println("패배");

        }





    }
}

