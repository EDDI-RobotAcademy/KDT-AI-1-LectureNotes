package problems.prob24;

public class Problem24 {
    public static void main(String[] args) {
        // 24 ~ 26번까지 모두 완료했습니다.
        GasManager gasManager = new GasManager();

        gasManager.addGasStation();
        System.out.println(gasManager);

        gasManager.calculateDistance();
        System.out.println(gasManager);

        gasManager.findClosestGasStation();
    }
}
