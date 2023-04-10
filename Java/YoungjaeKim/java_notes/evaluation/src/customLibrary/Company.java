package customLibrary;

public class Company {
    final String name;
    final int sales;
    final int staffCount;
    final int avgSalary;

    public String getName() {
        return name;
    }

    public int getSales() {
        return sales;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public int getAvgSalary() {
        return avgSalary;
    }

    public Company (String name, int sales, int staffCount, int avgSalary) {
        this.name = name;
        this.sales = sales;
        this.staffCount = staffCount;
        this.avgSalary = avgSalary;
    }
}
