package test2.arrayList.upgrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementArray {

    int[] arr1 = {5, 9, 7, 10};

    public static int[] solution ( int[] arr1, int int1){
        List<Integer> arr1List =new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % int1 == 0) {
               arr1List.add(arr1[i]);
            }
        }
        int[] sol = new int[arr1List.size()];
        for(int i=0; i<arr1List.size(); i++) {
            sol[i] = arr1List.get(i);
        }
        return sol;
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 8,2, 10};
        int div = 5;
        System.out.println(Arrays.toString(solution(arr1, div)));

    }
}