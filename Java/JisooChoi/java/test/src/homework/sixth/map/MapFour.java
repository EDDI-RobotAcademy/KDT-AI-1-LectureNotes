package homework.sixth.map;

import java.util.HashMap;
import java.util.Scanner;

class Map{
    HashMap<String, String> map = new HashMap<>();

    public Map(){}

    public void addMap(){
        System.out.println("친구 별명과 실명을 입력해주세요 >");
        for(int i = 0; i < 2; i++){
            Scanner scan = new Scanner(System.in);
            System.out.print("친구 ★별명: ");
            String nickName = scan.nextLine();
            System.out.print("친구 실명: ");
            String realName = scan.nextLine();
            map.put(nickName, realName);
        }
    }

    public void infoMap(){
        System.out.println(map);
    }
}

public class MapFour {
    public static void main(String[] args) {
        Map map = new Map();
        map.addMap();
        map.infoMap();
    }
}
