package problem.mapProb1;

import java.util.HashMap;
import java.util.Map;

class NicknameMap {
    private Map<String, String> nicknameInfo = new HashMap<>();

    public void setNickname(String name, String nickname) {
        nicknameInfo.put(name, nickname);
    }

    public String getNickname (String name) {
        return nicknameInfo.get(name);
    }
}

public class Nickname {
    public static void main(String[] args) {
        NicknameMap nickname = new NicknameMap();
        final String name1 = "철수";
        final String name2 = "영희";
        final String nickname1 = "철이";
        final String nickname2 = "영이";

        nickname.setNickname(name1, nickname1);
        nickname.setNickname(name2, nickname2);

        System.out.println(name1 + "의 별명은 " + nickname.getNickname(name1));
        System.out.println(name2 + "의 별명은 " + nickname.getNickname(name2));
    }
}
