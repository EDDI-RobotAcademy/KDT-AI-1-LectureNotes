package homework.cardex;

public class Cardex { // EnumTest를 작성한 이후 만들어준 코드
    final private CardPattern cardPattern;

    // 생성자
    public Cardex(CardPattern cardPattern) {
        this.cardPattern = cardPattern;
    }

    @Override
    public String toString() {
        return "Cardex{" +
                "cardPattern=" + cardPattern +
                '}' + '\n';
    }
}
