package etc;

public class Player {
    String name;
    int score;
    int DiceSum =0;

    public int rollDice(){
        Dice1[] DiceArray = new Dice1[2];
        for(int i =0; i<DiceArray.length; i++){
            DiceArray[i]= new Dice1();
            this.DiceSum += DiceArray[i].getRandomDice();
        }
        return DiceSum;
    }

    public int getDiceSum() {
        return DiceSum;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", DiceSum=" + DiceSum +
                '}';
    }
}
