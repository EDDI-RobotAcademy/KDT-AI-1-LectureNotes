package customLibrary.prob2;

public class Company {
    final String companyName = "네이버"; //이름
    final String sales = "100조";// 매출
    final String employees = "3000명";//직원수
    final String income = "6000천만원";//연봉

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSales() {
        return sales;
    }

    public String getEmployees() {
        return employees;
    }

    public String getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", sales='" + sales + '\'' +
                ", employees='" + employees + '\'' +
                ", income='" + income + '\'' +
                '}';
    }
}
