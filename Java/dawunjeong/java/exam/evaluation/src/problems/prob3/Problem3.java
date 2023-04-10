package problems.prob3;

import java.util.ArrayList;
import java.util.List;

// 문제 3번
class TextList{
    final List<String> english_UppercaseList = new ArrayList<>();

    public TextList() {
        english_UppercaseList.add("A");
        english_UppercaseList.add("B");
        english_UppercaseList.add("C");
        english_UppercaseList.add("D");
        english_UppercaseList.add("E");
        english_UppercaseList.add("F");
        english_UppercaseList.add("G");
        english_UppercaseList.add("H");
        english_UppercaseList.add("I");
        english_UppercaseList.add("J");
    }

    @Override
    public String toString() {
        return "TextList{" +
                "english_UppercaseList=" + english_UppercaseList +
                '}';
    }
}
public class Problem3 {
    public static void main(String[] args) {
        TextList textList = new TextList();
        final int MIN = 0;
        final int MAX = 9;
        int index = (int)(Math.random()*(MAX - MIN + 1)) + MIN;
        System.out.println(textList.english_UppercaseList.get(index));
    }
}
