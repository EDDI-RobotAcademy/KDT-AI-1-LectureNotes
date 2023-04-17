package test.test3;

import dicegame.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Number {
    //최솟값
    final int START;
    //최대값
    final int END;
//생성자 생성
    public Number(int START, int END) {
        this.START = START;
        this.END = END;
    }
    //List<Integer> 메서드 (int 대입값){List<Integer> tmpNumber 를 new ArrayList<>() 하고
    // for (int i = 최솟값; i <= 최대값; i++증감){
    // if 만약(i % 대입값 == 0)이면 { 메서드.add(i);이다}
    // } return 메서드;(초기화)
    // }
    public List<Integer>QuestionNumberOne(int even) {
        List<Integer> tmpNumber = new ArrayList<>();
        for (int i = START; i <= END; i++){
            if(i % even == 0){
                tmpNumber.add(i);
            }
        }
        return tmpNumber;
    }
    public List<Integer>ThreeDrainage(int Three){
        List<Integer> tmpNumber = new ArrayList<>();
        for (int i = START; i <= END; i++){
            if (i % Three == 0){
                tmpNumber.add(i);
            }
        }
        return tmpNumber;
    }
    public int FourDrainage(int Four){
        int Total = 0;
        for (int i = START; i <= END; i++){
            if (i % Four == 0){
                Total += i;
            }
        }
        return Total;
    }


}
