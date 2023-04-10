package test2.classPracticeYu;

public class BankCountTest {
    public static void main(String[] args) {
        BankCount Woori = new BankCount(50000);
        Woori.addMoney(1000);

        Woori.outMoney(10000);
        System.out.println(Woori);

    }
}
