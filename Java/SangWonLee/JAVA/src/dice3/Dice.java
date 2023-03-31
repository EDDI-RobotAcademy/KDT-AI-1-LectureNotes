package dice3;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    int START = 0;
    int diceMany = 3; // 주사위 갯수
    int oddDice = 2; // 홀,짝 판별 할때 쓰일 숫자.
    int maxDice = 6;
    int minDice = 1;
    int sumDice;


    List<String> playerName = new ArrayList<>(); // 플레이어 이름 리스트
    List<Integer> diceList = new ArrayList<>(); // 주사위 숫자 리스트

    List<Integer> sumDiceList = new ArrayList<>(); // 주사위 합 리스트

    List<List<Integer>> allDiceList = new ArrayList<>(); // 각각 플레이어의 주사위 숫자 리스트

    public Dice(List<String> playerName) {
        this.playerName = playerName;
    }

    public List<List<Integer>> rollDice() {
        System.out.println();

        for (int j = START; j < playerName.size(); j++) {
            for (int i = START; i < diceMany; i++) {
                diceList.add(CustomRandom.generateNumber(minDice, maxDice));
                if (diceList.get(0) % oddDice == 1) { // 만약 diceList.get(0)가 짝수면,
                    continue;
                } else {
                    break;
                }
            }
            allDiceList.add(diceList);
            diceList = new ArrayList<>(); // diceList 초기화
        }

        for (int i = START; i < playerName.size(); i++) {
            System.out.println(playerName.get(i) + " 님 현재 주사위 상태 : " + allDiceList.get(i));
        }

        System.out.println("----------------------------------------------------------");



        return allDiceList;
    }

    public List<List<Integer>> getAllDiceList() {
        return allDiceList;
    }

    public void setAllDiceList(List<List<Integer>> allDiceList) {
        this.allDiceList = allDiceList;
    }

    public List<Integer> diceSumList(List<List<Integer>> allDiceNumber) {

        for (int i = START; i < allDiceNumber.size(); i++) {
            for (int j : allDiceNumber.get(i)) {
                sumDice += j;

            }
            sumDiceList.add(sumDice);
            sumDice = 0;
        }

        for (int i = START; i < allDiceNumber.size(); i++) {
            System.out.println(playerName.get(i) + " 님 현재 점수 " + sumDiceList.get(i) + " 점 입니다 !!");
        }

        System.out.println("----------------------------------------------------------");

        return sumDiceList;
    }
}







