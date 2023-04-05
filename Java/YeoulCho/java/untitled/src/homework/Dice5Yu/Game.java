package homework.Dice5Yu;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playList = new ArrayList<>();




    public void addPlayer() {

        int randomPlayerNumber = CustomRandom.generateNumber(2, 10);
        for (int i = 0; i < randomPlayerNumber; i++) {
            playList.add(new Player());
        }

    }


    public void rollDice() {
        for (int i = 0; i < playList.size(); i++) {
            final int NumberOfDice = 3;

            for (int j = 0; j < NumberOfDice; j++) {
                Dice d1 = new Dice();
                d1.randomDiceNumber();
                Player currentPlayer = playList.get(i);
                Score currentPlayerScore = currentPlayer.getScore();

                currentPlayer.diceList.add(d1);
                currentPlayerScore.setTotalScore(currentPlayerScore.getTotalScore() + d1.getDiceNumber());
                if (currentPlayer.diceList.get(0).getDiceNumber() % 2 == 0) {
                } else {
                    break;
                }


            }

        }

        System.out.println(playList);
    }

    public int findThreeDice() {
        int thirdDice = 0;

            for (int i = 0; i < playList.size(); i++) {
                if (playList.get(i).diceList.size() == 3) {
                thirdDice = playList.get(i).diceList.get(2).getDiceNumber();
            }
        }
        return thirdDice;
    }

//    public void targetThirdDiceNumberSum() {
//        int targetThirdDiceNumber = 0;
//        int targetThirdDiceNumberSum = 0;
//        for (int i = 0; i < playList.size(); i++) {
//            if (findThreeDice() != 0 && findThreeDice() ==1) {
//                targetThirdDiceNumber++;
//            }
//            targetThirdDiceNumberSum += targetThirdDiceNumber;
//        }
//
//    }
    public void calculateTotalScore() {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).diceList.size() == 3) {
                switch (findThreeDice()) {
                    case 1: {
                        for(Player targetPlayer : playList) {
                            if (playList.get(i) == targetPlayer) {
                                playList.get(i).getScore().totalScore += 3;
                            } else {
                                targetPlayer.getScore().totalScore -= 3;
                            }
                        }
                        break;
                    }
                    case 3: {
                        playList.get(i).getScore().totalScore += 2;
                        break;
                    }
                    case 4: {
                        playList.get(i).getScore().totalScore -= 77777;
                        break;
                    }

                }
            }
        }
    }
}
