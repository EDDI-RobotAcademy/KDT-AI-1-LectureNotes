package problems.prob20;


import customLibrary.customRandom.CustomRandom;
//3.  랜덤한 숫자가 출력되도록 프로그램을 작성해주세요.
class RandomNumber {
    private int randomNumber = CustomRandom.generateNumber(0,1000000);

    @Override
    public String toString() {
        return "RandomNumber{" +
                "randomNumber=" + randomNumber +
                '}';
    }
}

public class Problem20 {
    public static void main(String[] args) {
        System.out.println(new RandomNumber());
    }
}
