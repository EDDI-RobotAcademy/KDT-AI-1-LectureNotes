package customLibrary.prob6;

public class Multiple {
    final int Min;
    final int Max;
    final int multiple;

    public Multiple(int Min, int Max, int multiple) {
        this.Min = Min;
        this.Max = Max;
        this.multiple = multiple;
    }

    public void multiplePrint() {
        for (int i = Min; i <= Max; i++) {
            if (i % multiple == 0) {
                System.out.println(Min + " 부터 " + Max +
                        "까지의 " + multiple +
                        "의 배수를 출력: " + i);
            }
        }
    }
}
