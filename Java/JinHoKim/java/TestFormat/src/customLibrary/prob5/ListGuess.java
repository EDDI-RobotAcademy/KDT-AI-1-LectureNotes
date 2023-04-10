package customLibrary.prob5;

import java.util.ArrayList;
import java.util.List;

public class ListGuess {
    List<Integer> integerList = new ArrayList<>();

    //3 3 3 6 9 12 18 27 39 57...
    // 3 3 3 6 9 12 18 27 39 57 84 123 180 264 387 567 831 1218 1785 2616
    public ListGuess() {
        integerList.add(3);
        integerList.add(3);
        integerList.add(3);
        integerList.add(6);
        integerList.add(9);
        integerList.add(12);
        integerList.add(18);
        integerList.add(27);
        integerList.add(39);
        integerList.add(57);
        integerList.add(84);
        integerList.add(123);
        integerList.add(180);
        integerList.add(264);
        integerList.add(387);
        integerList.add(567);
        integerList.add(831);
        integerList.add(1218);
        integerList.add(1785);
        integerList.add(2616);
        integerList.add(3834);
    }

    public void pick(int n) {
        int pickNum = integerList.get(n);
        System.out.println(pickNum);
    }
}
