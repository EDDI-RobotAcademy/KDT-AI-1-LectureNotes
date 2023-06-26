package review1.reviewTestCode;

import java.util.ArrayList;
import java.util.List;

public class ReviewTestCode {
    public static void main(String[] args) {
        List<TemporaryPlayer> playerList = new ArrayList<>();
        String[] nameArray = { "김00", "이00" };

        for (int i = 0; i < 2; i++) {
            playerList.add(new TemporaryPlayer());
            playerList.get(i).playerAdd(nameArray[i]); // 플레이어 이름 추가
        }

        System.out.println(playerList);
    }
}
