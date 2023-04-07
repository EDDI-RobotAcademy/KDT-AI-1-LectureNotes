package basic.classVersion.practiceYu;

import java.util.List;

public class ClassBasicTest {
    public static void main(String[] args) {
        ClassBasic c1 = new ClassBasic(1,100);
        List<Integer> c1List = c1.findNumber(2);
        System.out.println(c1List);


        ClassBasic c2 = new ClassBasic(1,100);
        List<Integer> c2List = c2.findNumber(3);
        System.out.println(c2List);


        ClassBasic c3 = new ClassBasic(1,100);
        List<Integer> c3List = c3.findNumber(4);
        int fourSum = c3.findNumberSum(4);
        System.out.println(c3List);
        System.out.println(fourSum);
    }
}
