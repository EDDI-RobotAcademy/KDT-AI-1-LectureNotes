package problems.prob4;

public class PlusNumber {
    final private int MIN_NUMBER = 54;
    final private int MAX_NUMBER = 132;
//    List<Integer> numberList = new ArrayList<>();

    public void getNumberSum() {

        int numberSum = 0;

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
//            numberList.add(i);
            numberSum += i;
        }

        System.out.println(numberSum);
    }
}
