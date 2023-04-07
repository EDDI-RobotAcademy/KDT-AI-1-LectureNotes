package problems.prob12;

import customLibrary.CustomRandom;

class Student {
    final int MIN = 0;
    final int MAX = 100;
    int StudentNum = 20;
    String[] str = new String[StudentNum];
    int n = str.length;
    int Sum = 0;
    int tmp = 0;
    int average;

    void Average () {
        for (int i = 1; i <= n; i++) {
            average = CustomRandom.generateNumber(MIN, MAX);
            System.out.println(i + "번 학생의 점수: " + average);
            Sum += average;
            if (average < i){
                average = i;
                tmp = i+1;
            }
        }
        System.out.println(tmp);
    }
}
