package customLibrary.prob15;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    List<Integer> numberList = new ArrayList<>();
    final int position;

    public NumberList(int position) {
        this.position = position;

        for (int i = 0; i < position; i++) {
            numberList.add((2 * i + 1));
        }
    }

    public void pickPosition() {
        int num;
        num = numberList.get(position - 1);
        System.out.println(num);
    }
}
