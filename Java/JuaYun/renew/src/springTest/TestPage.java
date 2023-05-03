package springTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class TestPage {
    private List<Integer> HealthList = new ArrayList<>();
    private int dayCount = 7;

    public TestPage() {
        for (int i = 0; i < dayCount; i++) {
            HealthList.get(i);
            System.out.println(HealthList);
        }
    }

    @Override
    public String toString() {
        return "testPage{" +
                "HealthList=" + HealthList +
                '}';
    }

}
