package problems.prob4;
//54~132 더하기
class Program{
    final int START = 54;
    final int END = 132;
    int Sum = 0;

    public int Sum54to132 () {
        for (int i = START; i <= END; i++) {
            Sum += i;
            //System.out.println(i + "부터 더하기 " + (i + 1) + "=" + (tmpSum + i));
        }
        //System.out.println(tmpSum);
        return Sum;
    }

    @Override
    public String toString() {
        return "Program{" +
//                "START=" + START +
//                ", END=" + END +
                "tmpSum=" + Sum +
                '}';
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Program p1 = new Program();
        p1.Sum54to132();
        System.out.println("54부터 132를 더하면" + p1);

    }



    }

