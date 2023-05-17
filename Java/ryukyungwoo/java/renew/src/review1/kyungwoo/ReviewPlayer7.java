package review1.kyungwoo;

import java.util.ArrayList;
import java.util.List;

public class ReviewPlayer7 {

    final int MAX_DICE_NUM = 4;
    List<ReviewDice7> diceList;

    // 일단 Player가 diceList를 가진다는 일차 목표 완성
    public ReviewPlayer7() {
        diceList = new ArrayList<>();

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceList.add(new ReviewDice7());
        }
    }

    @Override
    public String toString() {
        return "ReviewPlayer7{" +
                "diceList=" + diceList +
                '}' + '\n';
    }
}
