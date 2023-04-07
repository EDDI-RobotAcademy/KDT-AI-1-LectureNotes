package problems.prob2;
// 2. 회사 클래스를 만들어봅시다. 회사는 이름, 매출, 직원 수, 평균 연봉 정보를 가지고 있습니다.
public class Problem2 {
    public static void main(String[] args) {
        Company company = new Company("김이름", 500000);
        System.out.println(company);
        company.caculateSalary(1000000000, 25);
    }
}
