package problems.prob2;

public class Company {
        final private String companyName;
        final private int companySales;
        final private int workerNum;
        final private int wageAverage;

    public Company(String companyName, int companySales, int workerNum, int wageAverage) {
        this.companyName = companyName;
        this.companySales = companySales;
        this.workerNum = workerNum;
        this.wageAverage = wageAverage;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companySales=" + companySales +
                ", workerNum=" + workerNum +
                ", wageAverage=" + wageAverage +
                '}';
    }
}
