package review1.jua;

import diceGame.game.Dice;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

class RandomDiceList {
    private int MAX = 6;
    private int MIN = 1;
    private int diceNumber;
    List<Integer> diceList = new ArrayList<>();

    public RandomDiceList(int diceNumber) {
        this.diceNumber = diceNumber;
        // 아래 코드를 보니까 diceNumber를 for Loop 반복 회수로 사용하고 있습니다.
        // 그러므로 diceNumber를 고정시키거나 외부에서 주입받아야 합니다.
        // 기존엔 final로 고정시켰는데 이번엔 외부 주입을 해보겠습니다.
        for(int i = 0; i < diceNumber; i++) {
            // 지금 올려보니까 아래와 같은 에러 메시지가 나타나고 있는데
            // 이 부분은 Dice 타입이 필요한데 CustomRandom이 int를 생성해서 그렇습니다.
            // 그러므로 add 할 때 new Dice()에 CustomRandom을 적용하면 됩니다.
            int tmpDiceNumber = CustomRandom.generateNumber(MAX,MIN);

            // 넣을려고 했더니 Dice() 생성자가 외부 입력이 불가능합니다.
            // 이런 경우 선택 할 수 있는 전략은 세 가지가 나옵니다.
            // 1. Dice() 생성자에 정수형 숫자 입력을 가능하게 만듭니다.
            // 2. Dice() 타입은 그냥 추가하면 되니까 별도 CustomRandom을 사용하지 않고 생성한다.
            // 3. 만약 CustomRandom을 사용하고 싶다면 위의 리스트를 Integer 타입으로 바꿉니다.
            // CustomRandom을 사용했으니까 3번 전략으로 풀이해보겠습니다.
            diceList.add(tmpDiceNumber);
        }
    }

    public List<Integer> getDiceList() {
        return diceList;
    }

    @Override
    public String toString() {
        return "RandomDiceList{" +
                "diceList=" + diceList +
                '}';
    }
}

// List<Player> playerList;
// [0번 인덱스, 사용자 0] -> [1번 인덱스, 사용자 1]
// Player가 List<Dice> 혹은 List<Integer>를 들고 있다면 ?
// 사용자 0은 아래 정보를 가지고 있음
// [0번 인덱스, 주사위 0] -> [1번 인덱스, 주사위 1] -> [2번 인덱스, 주사위 2]
public class FirstDiceGameReview {
    public static void main(String[] args) {
        final int DICE_NUMBER = 3;
        RandomDiceList randomDiceList = new RandomDiceList(DICE_NUMBER);
        System.out.println(randomDiceList);
        // 우선 여기까지 한 템포
        // 출력 결과를 살펴보니까
        // 아래와 같은 리스트가 출력됩니다.
        // RandomDiceList{diceList=[5, 6, 4]}

        // 그럼 이제 이 출력 결과를 보면서 생각해보는 것입니다.
        // 리스트가 하나 나왔는데 이게 주사위 리스트구나
        // 그렇다면 이 리스트는 사용자마다 필요하겠지 ?
        // 사용자에게 주사위 리스트를 주자 형태로 만들 수 있습니다.
        // 또 다른 방법은 Player 리스트를 만들고
        // 또 RandomDiceList를 만들어서
        // 두 번 만드는 것인데
        // 코드가 안예뻐집니디만 한 번 해보죠.

        // PlayerList playerList = new PlayerList(randomDiceList);
        // 여기서도 선택 할 수 있는 전략이 두 가지 나오게 됩니다.
        // 1. 만들어놓은 randomDiceList를 입력으로 전달한다.
        // 2. 만들어놓은 randomDiceList에 get을 사용해서 리스트를 전달한다.
        // 이번엔 2번 전략을 사용해보겠습니다. (수업땐 1번을 사용했었으니까요)
        PlayerList playerList = new PlayerList(randomDiceList.getDiceList());
        System.out.println(playerList);

        // 출력해보니까 문제가 생기네요 ?
        // 같은 숫자가 두 개 들어가는 기현상이 발생할 것입니다.
        // 왜냐하면 입력받은 randomDiceList.getDiceList()가 리스트 1개짜리고
        // PlayerList의 생성자는 이 정보를 바탕으로 반복하기 때문입니다.
        // 그렇다면 이제 취할 수 있는 전략은
        // RandomDiceList를 내부로 끌고 들어가자라는 전략을 취할 수 있을 것입니다.
        // PlayerList 루프 돌 때 쟤를 집어넣어야겠다라는 전략입니다.
        // 아래와 같이 변형을 해봅시다.
        PlayerList playerList2 = new PlayerList();
        System.out.println(playerList2);

        // 맨 처음은 같은 숫자를 반복하지만
        // 두 번째는 달라지는 것을 확인 할 수 있습니다.
        // 요런 형태로 진행하면 좋을 것 같습니다.
        // 뒷부분 리뷰까지 하면 집중이 분산될 것 같으니 일단 여기서 끊겠습니다.
    }
}
