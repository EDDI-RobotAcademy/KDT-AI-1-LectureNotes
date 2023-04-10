package customLibrary.prob5;

import java.util.ArrayList;

public class NumberList {
    ArrayList<Integer> thirdNum = new ArrayList<>();;

    public NumberList(){}

    public void thirdNum() {
        for(int i = 1; i < 100; i++){
            if(i % 3 == 0){
                thirdNum.add(i);
            }
        }

        for(int i = 0; i< thirdNum.size(); i++){
            System.out.println(thirdNum.get(i));
        }
    }
}

//     [1 2 3]     [6]      [9]         [13]              [19]
//      3 6 9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60

// [0 1 2 3 4 5]    [7]     [10]        [14]              [20]
//  3 3 3 6 9 12    18       27          39                57
//    0 0 3 6 6      6       9           12                18