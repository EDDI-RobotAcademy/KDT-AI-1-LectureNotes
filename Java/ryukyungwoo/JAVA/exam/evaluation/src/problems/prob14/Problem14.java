package problems.prob14;
//
///*
//3.  3 ~ 33까지 숫자 중 당첨 번호를 랜덤으로 뽑습니다.
//    사용자 키보드 입력을 받아 번호를 선택하고 선택한 번호가 당첨 번호가 맞다면 승리합니다.
//    만약 맞지 않다면 총 7번의 기회가 주어집니다. 7번의 기회를 모두 소진하면 자동 패배 처리 됩니다.
//
// */
//
import customLibrary.customRandom.CustomRandom;

import java.util.Scanner;

class GenerateRandomNumber {
    final private int MAX_WANTED_NUM = 33;
    final private int MIN_WANTED_NUM = 3;
    private int generatedNumber;

    public GenerateRandomNumber () {
        this.generatedNumber = CustomRandom.generateNumber(MIN_WANTED_NUM, MAX_WANTED_NUM);
    }
    public int getGeneratedNumber() {
        return generatedNumber;
    }
    @Override
    public String toString() {
        return "GenerateRandomNumber{" +
                "generatedNumber=" + generatedNumber +
                '}';
    }
}


class ScanningInputNumber {
    Scanner scanner = new Scanner(System.in);
    private int inputNumber = scanner.nextInt();
    public ScanningInputNumber () {
        System.out.println(inputNumber);
    }

    public int getInputNumber() {
        return inputNumber;
    }
    @Override
    public String toString() {
        return "ScanningInputNumber{" +
                "inputNumber=" + inputNumber +
                '}';
    }
}


class CheckNumbers {
    final private int CHECKING_CHANCE = 0;
    private int currentChance;
    final private int BIAS = 1;
    //       if (new ScanningInputNumber().getInputNumber() == new GenerateRandomNumber().getGeneratedNumber()) {
//           System.out.println("당첨");
//       } else {
//           System.out.println("꽝");
//           currentChance = MAX_CHECKING_CHANCE -1;
//       }
//    }
    public CheckNumbers () {
        currentChance = 7 - BIAS;
        while (CHECKING_CHANCE < currentChance) {
            if (new ScanningInputNumber().getInputNumber() == new GenerateRandomNumber().getGeneratedNumber()) {
                System.out.println("당첨!");
            }
            if (new ScanningInputNumber().getInputNumber() != new GenerateRandomNumber().getGeneratedNumber()) {
                System.out.println("꽝!");
                currentChance -= 1;
                System.out.println(currentChance);
            }
        }
    }

    @Override
    public String toString() {
        return "CheckNumbers{" +
                "currentChance=" + currentChance +
                '}';
    }
}
public class Problem14 {
    public static void main(String[] args) {
        System.out.println("숫자를 입력해주세요: ");
        System.out.println(new CheckNumbers());
    }
}
