

// 복합 문제 24~26
// 결과가 나오긴 나옵니다. 하지만 더 깨끗하게 만들 수 있었을거 같지만 시간 부족으로 ㅜㅜ..
// 일단 이렇게 제출하겠습니다.
// 27번 문제 아주 조금 하였습니다.


package problems.prob24;

import java.util.ArrayList;
import java.util.List;

public class Problem24 {
    public static void main(String[] args) {

        List<Coordinate> coordinateArrayList = new ArrayList<>();
        Coordinate coordinate = new Coordinate();

        for (int i = 0; i <2 ;i++){
            coordinateArrayList.add(new Coordinate());
        }
        System.out.println("현재 내 위치는 : " + coordinateArrayList.get(0).getTotalCoordinate() + " 입니다.");
        System.out.println("주유소 위치는 : " + coordinateArrayList.get(1).getTotalCoordinate() + " 입니다.");


        coordinate.calculateCoordinate(coordinateArrayList);













    }
}
