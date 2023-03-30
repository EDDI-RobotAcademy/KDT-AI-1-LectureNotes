package homework.sixth.practice;

import java.util.ArrayList;

public class GameDice {
    // 플레이어 -> (주사위 각 3개) as 여기서는 하나의 리스트로 표현
    // 누적 총 점수

    final private int DICE_MAX_NUMBER = 3;
    // Dice에서 받아오는 주사위 3개 리스트
    ArrayList<Dice> diceNumArray;
    private int totalScore; // 총점은 각 점수가 누적되어야 하니까 여기가 아닌 score 리스트 가져오기?

    // 게임이 시작하려면 주사위를 굴려야 한다 !
    // 그러면 게임 객체에서 변수를 선언하고 생성하는 과정에서 랜덤 번호 3개를 받아오는 게 맞을 듯?

    public GameDice(){
        diceNumArray = new ArrayList<>();
    }

    // 굴린 주사위 객체 각각을 이제 리스트에 넣어주어야 하는데
    // 어떻게 넣을 수 있을까?
    // 주사위 넣는 객체 리스트가 Dice 타입이라, 동일 타입을 받을텐데
    // 그래서 객체 생성해서 넣어주어야 하는데 Dice에서 만들어준
    // diceNum을 어떻게 가져오지?
    public int addDiceArray(){
        final int FIRST_DICE_INFO = 0;
        for(int i = 0; i < DICE_MAX_NUMBER; i++){
            diceNumArray.add(new Dice());

            totalScore += diceNumArray.get(i).getDiceNum();

            if(diceNumArray.get(FIRST_DICE_INFO).getDiceNum() % 2 == 1){
                break;
            }
        }
        return totalScore;
    }

    public void gamePlay(){
        final int thirdDice = diceNumArray.size() - 1;

        while(true){
            if(diceNumArray.get(thirdDice).getDiceNum() == 1){
                System.out.println("친구에게 점수 3점 빼앗기");
                break;
            }

            if(diceNumArray.get(thirdDice).getDiceNum() == 3){
                System.out.println("자신에게 2점 가산하기");
                break;
            }

            if(diceNumArray.get(thirdDice).getDiceNum() == 4){
                System.out.println("패배!");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "GameDice{" +
                "diceNumArray=" + diceNumArray +
                ", totalScore=" + totalScore +
                '}';
    }
}
