import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListList {


    public static void main(String[] args) {

        List<String> pocker = new ArrayList<>(Arrays.asList("A","2","3","4","5","6","7","8"));

        pocker.add(("9"));
        pocker.add(("10"));
        pocker.add(("J"));
        pocker.add(("Q"));
        pocker.add(("K"));

        System.out.println(pocker);
    }
}
