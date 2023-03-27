package flowControl;

public class SwitchYield {

    public static void main(String[] args) {
        int conditionNum = 2;
        final int num;

        num = switch (conditionNum) {
            case 1 -> 3;
            case 2 -> {
                System.out.println("case2");
                yield 4;
            }
            case 3 -> 5;

            default -> 0;
        };

        System.out.println(num);
    }
}
