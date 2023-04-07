package problems.prob14;
// 3 ~ 33까지 숫자 중 당첨 번호를 랜덤으로 출력.
// 사용자 키보드 입력을 받아 번호를 선택하고 선택한 번호가 당첨 번호가 맞다면 승리.
// 만약 맞지 않다면 총 7번의 기회.
// 7번의 기회를 모두 소진하면 자동 패배 처리.
public class Problem14 {
    public static void main(String[] args) {
        int MIN = 3;
        int MAX = 33;
        int START = 0;
        int END = 7;

        int NUMBER = (int)(Math.random() * (MAX - MIN + 1) + MIN);

    }
}
