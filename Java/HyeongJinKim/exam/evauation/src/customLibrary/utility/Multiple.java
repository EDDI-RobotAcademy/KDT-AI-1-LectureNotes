package customLibrary.utility;

import java.util.ArrayList;
import java.util.List;

public class Multiple {
    public static List<Integer> generateMultipleList (int start, int end, int decision) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i % decision == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
