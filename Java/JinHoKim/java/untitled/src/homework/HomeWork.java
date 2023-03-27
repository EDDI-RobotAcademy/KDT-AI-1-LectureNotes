package homework;

public class HomeWork {
    public class Dice {
        final int diceA = (int)(Math.random() * 6) + 1;
        final int diceB = (int)(Math.random() * 6) + 1;
        final int diceC = (int)(Math.random() * 6) + 1;
        final int diceD = (int)(Math.random() * 6) + 1;

    }


    public void main(String[] args) {
        final int diceA = (int)(Math.random() * 6) + 1;
        final int diceB = (int)(Math.random() * 6) + 1;
        final int diceC = (int)(Math.random() * 6) + 1;
        final int diceD = (int)(Math.random() * 6) + 1;



        System.out.println("A주사위 + B주사위 + C주사위 + D주사위 = " + (diceA + diceB + diceC + diceD));

        int diceSum = diceA + diceB + diceC + diceD;

        if (diceSum % 4 == 0 || diceSum % 3 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }

}


/*

 */
