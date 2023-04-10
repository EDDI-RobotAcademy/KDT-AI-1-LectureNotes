package test2.classPracticeYu;

public class BankCount {
    private int inputMoney;
    private int outputMoney;
    private int accountMoney;

    public void addMoney(int inputMoney) {
        accountMoney = accountMoney + inputMoney;
    }

    public void outMoney(int outputMoney) {
        accountMoney = accountMoney - outputMoney;
    }

    public BankCount(int accountMoney) {
        this.accountMoney = accountMoney;
    }

    @Override
    public String toString() {
        return "BankCount{" +
                "accountMoney=" + accountMoney +
                '}';
    }
}
