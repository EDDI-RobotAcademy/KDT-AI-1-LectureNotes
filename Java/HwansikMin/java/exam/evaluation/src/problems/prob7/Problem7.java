package problems.prob7;
//사과 가게에서 사과를 1개에 2000원씩 판매
//가게 주인 기분에 따라 가격의 변동이 발생
//가격 인상률은 3 ~ 20%
//이 내용을 적용하여 사과 가격 출력
public class Problem7 {
    public static void main(String[] args) {
        int APPLE = 2000;
        int MIN = 3;
        int MAX = 20;

        int INCREASE_RATE = (int)(Math.random() * (MAX - MIN + 1) + MIN);
        System.out.println("사과 가격 인상률 : " + INCREASE_RATE + "%");

        int INCREASE_APPLE = (APPLE/100) * INCREASE_RATE;
        System.out.println("사과 인상 가격 : " + INCREASE_APPLE);

        int APPLETOTAL = APPLE + INCREASE_APPLE;
        System.out.println("사과 최종 가격 : " + APPLETOTAL);
    }
}
