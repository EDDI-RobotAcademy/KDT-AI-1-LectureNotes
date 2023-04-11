package problems.prob21;

public class Worker {
    final private String name;
    private int income;

    public Worker(String name) {
        this.name = name;
        this.income = 20000000;
    }

    public String getName() {
        return name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
