package problems.prob3;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        final int START = 65;
        final int COUNT = 10;
        List<String> characterList = new ArrayList<>();

        for(int i=START; i < START+COUNT; i++) {
            characterList.add(""+(char)i);
        }
        System.out.println(characterList);

    }
}
