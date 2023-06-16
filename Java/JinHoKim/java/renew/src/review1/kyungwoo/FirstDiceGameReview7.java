package review1.kyungwoo;

import java.util.ArrayList;
import java.util.List;

public class FirstDiceGameReview7 {
    public static void main(String[] args) {
        /*
        필요한 것
        만들어진 플레이어 리스트랑
        다이스 리스트를 합치기
        List<List<>> 말고 다른 방법 생각하기
        어떻게 매칭 시킴?
        Dice()하면 3개가 나오고
        Player()하면 2개가 나옴
        일단 필요할것 같은 상수 다 만들기
         */
        
        // 일단 지금 하고 싶은 것이 Player가 Dice를 가지게 만들고 싶음
        // 또 Player를 2명 만들고 싶음
        // 둘 다 List로 만들고 싶음
        
        // 이런 경우엔 Player가 상위 집합인지 Dice가 상위 집합인지 고민해야 합니다.
        // 당연히 Player가 Dice 보다 상위 집합일 것입니다.
        // 그러므로 아래와 같은 전략을 세웁니다.
        // Player 내부에 Dice를 셋팅하자
        // 바로 고합니다.

        // 1. Player를 만들고 보니까 Dice가 없으니까 Dice를 만듭니다.
        ReviewPlayer7 player = new ReviewPlayer7();
        System.out.println(player);

        // Domain 단위로 볼 때 관심사 분리 되기 때문에
        // 비효율적인 사고를 할 필요가 없어집니다.
        // 2.
        final int MAX_PLAYER_NUM = 2;

        List<ReviewPlayer7> playerList = new ArrayList<>();

        for (int i = 0; i < MAX_PLAYER_NUM; i++) {
            playerList.add(new ReviewPlayer7());
        }

        System.out.println(playerList);
    }
}
