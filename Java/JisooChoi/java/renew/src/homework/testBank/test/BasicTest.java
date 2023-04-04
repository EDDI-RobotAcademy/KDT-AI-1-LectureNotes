package homework.testBank.test;

class TestEvenPrint{
    private int evenNum;

    public TestEvenPrint() {}

    public void findEven(){
        final int EVEN_CHECK = 2;
        final int EVEN = 0;

        for(int i = 1; i <= 100; i++){
            if(i % EVEN_CHECK == EVEN){
                evenNum = i;
                System.out.printf("%d ",evenNum);
            }
        }
    }
}

class multipleThree{
    private int threeMultiple;

    public multipleThree() {}

    public void multipleThreePrint(){
        final int THREE_CHECK = 3;
        final int THREE_CORRECT = 0;

        for(int i = 1; i <= 100; i++){
            if(i % THREE_CHECK == THREE_CORRECT){
                threeMultiple = i;
                System.out.printf("%d ",threeMultiple);
            }
        }
    }
}

class multipleFourSum{
    private int fourMultiple;

    public multipleFourSum() {}

    public void multipleFourPrint(){
        final int FOUR_CHECK = 4;
        final int FOUR_CORRECT = 0;

        for(int i = 1; i <= 100; i++){
            if(i % FOUR_CHECK == FOUR_CORRECT){
                fourMultiple += i;
            }
        }
        System.out.printf("%d ",fourMultiple);
    }
}

public class BasicTest {
    public static void main(String[] args) {
        TestEvenPrint one = new TestEvenPrint();
        one.findEven();

        System.out.println();

        multipleThree two = new multipleThree();
        two.multipleThreePrint();

        System.out.println();

        multipleFourSum three = new multipleFourSum();
        three.multipleFourPrint();
    }
}
