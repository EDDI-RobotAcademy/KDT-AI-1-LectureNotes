package homework.practice;

import utility.random.CustomRandom;

public class Players {
    final int MIN = 0;
    final int MAX = 2;
    final String name;
    final private String[] RaffleArray = {"가위", "바위", "보"};
    final String raffleValue;

    public Players(String name){
        this.name = name;
        String value = Raffle();
        this.raffleValue = value;
    }

    public String Raffle(){
        return RaffleArray[CustomRandom.generateNumber(MIN, MAX)];
    }

    public String getRaffleValue() {
        return raffleValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +" = " + raffleValue ;
    }
}
