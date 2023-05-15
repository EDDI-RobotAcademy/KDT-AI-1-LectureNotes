package springTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class TestPage {
    private List<Integer> HealthList = new ArrayList<>();
    private int dayCount = 7;

    public TestPage() {
        for (int i = 0; i < dayCount; i++) {
            int num = CustomRandom.generateNumber(1,100);
            HealthList.add(num);
        }
        System.out.println(HealthList);
    }

    public List<Integer> getHealthList() {
        return HealthList;
    }

    @Override
    public String toString() {
        return "TestPage{" +
                "HealthList=" + HealthList +
                '}';
    }
}


