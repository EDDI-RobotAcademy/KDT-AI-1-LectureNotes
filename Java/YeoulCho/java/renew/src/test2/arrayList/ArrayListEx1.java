package test2.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("banana");
        wordList.add("strawberry");
        System.out.println(wordList);
        String firstWordList = wordList.get(0);
        System.out.println(firstWordList);

        for(int i =0; i< wordList.size();i++){
            System.out.println(wordList.get(i));
        }

    }
}
