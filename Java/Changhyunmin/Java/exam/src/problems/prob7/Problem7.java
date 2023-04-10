package problems.prob7;

public class Problem7 {
    public static void main(String[] args) {

        //7. 사과 가게에서 사과를 1개에 2000원씩 팔고 있습니다. 가게 주인 기분에 따라 가격의 변동이 발생합니다.
        // 가격 인상률은 3 ~ 20% 정도입니다. 이 내용을 적용하여 사과 가격을 출력해주세요.
        double ApplePrice = 2000;
        double MIN = 3;
        double MAX = 20;
        double RandomExample = (int)(Math.random()*MAX + MIN);
        double result;
        result = 2000 * (1.0 + RandomExample / 100.0);
        System.out.format("%.2f%n", result);

    }
}
