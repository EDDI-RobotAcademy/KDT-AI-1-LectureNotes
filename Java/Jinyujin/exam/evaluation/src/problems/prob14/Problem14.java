package problems.prob14;
// 3 ~ 33까지 당첨 번호 랜덤 생성 - 커스텀랜덤
// 키보드 입력 -> 번호 선택
// 번호 맞으면 승리
// 맞지 않으면 7번의 기회
// 7번 이후 자동 패배처리
public class Problem14 {
    public static void main(String[] args) {

        FindWinNumber findWinNumber = new FindWinNumber();
        findWinNumber.selectNumber();
    }
}
