package repeat.listTest;

import java.util.ArrayList;
import java.util.List;

public class ListHomework {

    public static void main(String[] args) {
        int [] cardNumbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);

        for (int i = 0; i < arrayList.size(); i++) {
                System.out.println("카드 번호: " + arrayList.get(i));
            }
        }
    }
