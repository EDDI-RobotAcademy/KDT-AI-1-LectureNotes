package customLibrary.prob3;

import java.util.ArrayList;

public class ArrayListRandom {
    final private ArrayList<String> arrayList = new ArrayList<>();
    final int START_NUM = 0;
    final int END_NUM = 10;

    public ArrayListRandom() {
    }

    public void addAlphabet(){
        for(int i = START_NUM; i < END_NUM; i++){
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("C");
            arrayList.add("D");
            arrayList.add("E");
            arrayList.add("F");
            arrayList.add("G");
            arrayList.add("H");
            arrayList.add("I");
            arrayList.add("J");
        }
    }

    public void randomAlphabet() {
        for(int i = START_NUM; i < END_NUM; i++){
            int randomNum = (int)(Math.random() * END_NUM-1) + START_NUM;
            System.out.println(arrayList.get(randomNum));
        }
    }
}
