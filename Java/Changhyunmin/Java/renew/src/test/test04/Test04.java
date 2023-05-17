package test.test04;

public class Test04 {
    public static void main(String[] args) {
        int Min = 1;
        int Max = 100;
        int Even = 2;
        TestNumber testNumber = new TestNumber(Min, Max);
        System.out.println(testNumber.TestNumberOne(Even));
        int Three = 3;
        System.out.println(testNumber.TestNumberTwo(Three));
        int Four = 4;
        System.out.println(testNumber.TestNumberThree(Four));

    }

}
