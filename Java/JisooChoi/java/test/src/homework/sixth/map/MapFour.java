package homework.sixth.map;

import java.util.HashMap;
import java.util.Scanner;

class FriendNameMap{
    HashMap<String, String> nameMap = new HashMap<>();

    public FriendNameMap(){}

    public void nameAddMap(){
        for(int i = 0; i < 2; i++){
            Scanner scan = new Scanner(System.in);
            System.out.print("친구 별명을 입력해주세요: ");
            String nickName = scan.nextLine();
            System.out.print("친구 실명을 입력해주세요: ");
            String realName = scan.nextLine();
            nameMap.put(nickName, realName);
        }
    }

    public void infoMap(){
        System.out.println(nameMap);
    }
}

public class MapFour {
    public static void main(String[] args) {
        FriendNameMap map = new FriendNameMap();
        map.nameAddMap();
        map.infoMap();
    }
}
