package customLibrary.prob2;

public class Company {
    final private String companyName;
    final private int sales;
    final private int staffNumber;
    final private int averageAnnualSalary;

    public Company(String companyName, int sales, int staffNumber, int averageAnnualSalary) {
        this.companyName = companyName;
        this.sales = sales;
        this.staffNumber = staffNumber;
        this.averageAnnualSalary = averageAnnualSalary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", sales=" + sales +
                ", staffNumber=" + staffNumber +
                ", averageAnnualSalary=" + averageAnnualSalary +
                '}';
    }
}
