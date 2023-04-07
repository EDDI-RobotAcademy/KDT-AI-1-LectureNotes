package problem.basicProb1.intoClass;

public class Main {
    public static void main(String[] args) {
        NumberGenerator basicProb1 = new NumberGenerator(1, 100, 2);
        basicProb1.getNumberList();

        NumberGenerator basicProb2 = new NumberGenerator(1, 100, 3);
        basicProb2.getNumberList();

        NumberGenerator basicProb3 = new NumberGenerator(1, 100, 4);
        basicProb3.getNumberSum();

        AppleList appleList = new AppleList();
        appleList.getAppleList();
        appleList.getAppleTotalCost();
    }
}
