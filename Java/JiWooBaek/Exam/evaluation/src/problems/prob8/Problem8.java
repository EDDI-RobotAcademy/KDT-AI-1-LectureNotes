package problems.prob8;

// 8번 문제입니다.
public class Problem8 {
    public static void main(String[] args) {
        // 이론 문제입니다.

        // final을 사용하는 이유는 두가지 이유가 있습니다. 첫번째로, 우선 상수로
        // 고정시킬 수 있다는 있다는 이점이 있는데, 예를 들면

        // final float FULL_PERCENT = 50;
        // final float TAX = 3,3f
        // int income = 5000000;

        // System.out.println("프리랜서 세전 수입: " + income + ",
        // 세후: " + income * (FULL_PERCENT - 3.3F -> TAX) / FULL_PERCENT);

        // 이러한 예시처럼, final을 사용하지 않았을때는 TAX값이 변경함에 따라 모든
        // 코드를 수정해야 하는 불편함이 발생하지만, TAX 상수에 숫자를 기입하고 사용하면
        // 모든 코드를 수정하지 않고 TAX 수치값만 변경할 수 있어서 모든 작업이 일괄처리 되므로 편합니다.

        // 두번째로는 클래스를 인스턴스화하여 객체를 만들었고 불변한다는 것입니다.
        // TAX = TAX + 4;
        // 위 코드는 TAX가 final이기 때문에 덧셈 ,뺄셈이 불가능하며 결론적으로
        // 입력값을 변경하지 못하게 막음으로서 동작의 무결성을 보장합니다.

    }
}
