package homework.seventh.mapquiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Nickname{
    final String nickname;
    final String name;
    Scanner sc = new Scanner(System.in);
    public Nickname(){
        this.nickname = sc.next();
        this.name = sc.next();
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }
}
public class MapQuiz4 {
    public static void main(String[] args) {
        Nickname nickname = new Nickname();

        Map<String, String> nicknameMap = new HashMap<>();

        nicknameMap.put(nickname.getNickname(), nickname.getName());

        System.out.println(nicknameMap);
    }
}
