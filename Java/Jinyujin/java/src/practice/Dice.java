package practice;
import utility.random.CustomRandom;

// 주사위 클래스
// 이 클래스에선 이거에만 집중할 것
public class Dice {

    // 1. 주사위 숫자 6개 랜덤 배치 - CustomRandom 활용(잘 출력됨)
    int diceNumber;

    public int getDiceNumber() {
        return diceNumber;
    } // 주사위 숫자를 이용하여 4개의 주사위 굴릴 수 있도록 getter 생성

    // 2. 주사위 4개 굴리기 - 배열과 for문 활용
//    int[] diceArray = new int[4];
    // 오류가 발생했으나 배열 초기화 시켜주니 오류는 사라짐
    // 그런데 주사위 숫자가 똑같은 값으로만 4개 나옴
    // 굴리는건 게임 클래스가 나을 꺼 같음

    public Dice() {
        diceNumber = CustomRandom.generateNumber(1, 6);
        }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
