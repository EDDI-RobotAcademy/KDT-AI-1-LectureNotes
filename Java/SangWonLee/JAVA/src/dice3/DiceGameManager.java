package dice3;

import java.util.*;

public class DiceGameManager {

    final int START = 0;

    final private List<Player> playerNameList = new ArrayList<Player>(); // 플레이어 이름 리스트
    List<Dice> diceList = new ArrayList<>(); // 주사위 숫자 리스트
    List<List<Dice>> diceNumberList = new ArrayList<>(); // 인원 수에 따른 주사위 숫자 리스트
    List<Score> scoreDiceList = new ArrayList<>(); // 주사위 합 리스트
    List<Score> resultDiceList = new ArrayList<>(); // 총 결과 주사위 리스트


    public List<Player> addPlayer() { // 플레이어 추가하기

        Scanner sc = new Scanner(System.in); // 몇 명인지 물어볼 때에 쓰일 Scanner
        Scanner sc1 = new Scanner(System.in); // 플레이어 이름 입력에 쓰일 Scanner

        System.out.print("몇 명이서 플레이 하실 겁니까? : ");
        int playerMany = sc.nextInt();

        int addStart = 1; // 플레이어 추가에 필요한 숫자
        for (int i = addStart; i <= playerMany; i++){
            System.out.print(i + " 번 플레이어의 이름을 입력해주세요 : ");
            playerNameList.add(new Player(sc1.nextLine()));

        }
        System.out.println(playerNameList);
        System.out.println(playerNameList.get(0));
        System.out.println(playerNameList.get(0).getPlayerNameList());

        for (int i = START; i < playerMany; i++){
            System.out.println(i+1 + " 번째 선수의 이름은 !! " + playerNameList.get(i).getPlayerNameList() + " 입니다 !!");
        }

        System.out.println("----------------------------------------------------------");


        return playerNameList;
    }

    public List<List<Dice>> rollDice() { // 주사위 굴리기

        int diceMany = 3; // 주사위 갯수
        int oddDice = 2; // 홀,짝 판별 할때 쓰일 숫자

        for (int j = 0; j < playerNameList.size() ;j++) {
            diceList = new ArrayList<>(); // diceList 안에 있는 값 초기화
            for (int i = 0; i < diceMany; i++) {
                diceList.add(new Dice());
                if(diceList.get(0).getDiceNumber() % oddDice == 0){
                    break;
                }
            }
            diceNumberList.add(diceList);
        }

        for (int i = START; i < playerNameList.size(); i++) {
            System.out.println(playerNameList.get(i).getPlayerNameList()
                    + " 님 현재 주사위 상태 : " + diceNumberList.get(i));
        }
        System.out.println("----------------------------------------------------------");

        return diceNumberList;
    }


    public List<Score> diceSum() { // 주사위 점수 합치기

        for (List<Dice> dice : diceNumberList) {
            int sumDice = START; // 주사위 합 초기화

            for (int i = START; i < dice.size(); i++) {
                sumDice += dice.get(i).getDiceNumber();
            }
            scoreDiceList.add(new Score(sumDice));
        }

        for (int i = START; i < scoreDiceList.size(); i++) {
            System.out.println(playerNameList.get(i).getPlayerNameList() + " 님 현재 점수 " + scoreDiceList.get(i).getScore() + " 점 입니다 !!");
        }
        System.out.println("----------------------------------------------------------");

        return scoreDiceList;
    }


    public List<Score> specialDice() { // 세번째 주사위

        int thirdDice = 2; // 세번째 주사위를 찾을 때 쓰일 숫자.

        SpecialDice specialDice = new SpecialDice(scoreDiceList);

        for (int i = START; i < diceNumberList.size(); i++) {
            switch (diceNumberList.get(i).get(thirdDice).getDiceNumber()) {
                case 1:
                    // 훔치기를 할건데 광역 공격으로 할거임
                    // 메소드를 만들어서
                    specialDice.stealScore();
                    break;
                case 3:
                    specialDice.eatScore();
                    break;
                case 4:
                    specialDice.defeatScore();
                    break;
            }
        }
        return resultDiceList;
    }

    public void resultDice() {

        int highScore = scoreDiceList.get(START).getScore(); // 높은 점수 값을 넣어줄 공간
        Score highScoreValue; //
        int highScoreIndex = 0;

        // 동점이면 앞에 있는 얘가 이기는 상황 발생
        for (int i = 0; i < scoreDiceList.size(); i++) {
            if (scoreDiceList.get(i).getScore() > highScore) {
                highScore = scoreDiceList.get(i).getScore();
                highScoreValue = scoreDiceList.get(i); // 높은 점수 일 때의 Value 값 저장
                highScoreIndex = scoreDiceList.indexOf(highScoreValue); // 높은 점수 일 때의 Index 값 저장
            }
        }
        System.out.println(highScore + " 의 점수로 " + playerNameList.get(highScoreIndex).getPlayerNameList() + " 님이 승리 하였습니다.");

    }

}






