package problems.prob2;

public class Problem2 {

    private String name;

    private int sales;
    private int employeenumber;

    private int averagesalary;

    public Problem2 (String name, int sales, int employeenumber, int averagesalary) {
        this.name = name;
        this.sales = sales;
        this.employeenumber = employeenumber;
        this.averagesalary = averagesalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(int employeenumber) {
        this.employeenumber = employeenumber;
    }

    public int getAveragesalary() {
        return averagesalary;
    }



    public void setAveragesalary(int averagesalary) {
        this.averagesalary = averagesalary;
    }

    public static void main(String[] args) {

    }
}
