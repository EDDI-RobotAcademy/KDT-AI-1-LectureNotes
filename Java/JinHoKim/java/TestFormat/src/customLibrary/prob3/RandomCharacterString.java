package customLibrary.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomCharacterString {
    List<String> CharacterList =
            Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
    List<String> randomCharacterList = new ArrayList<>(CharacterList);

    public void randomPrint() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomCharacterList.size());
        System.out.println(randomCharacterList.get(randomIndex));

    }
}
