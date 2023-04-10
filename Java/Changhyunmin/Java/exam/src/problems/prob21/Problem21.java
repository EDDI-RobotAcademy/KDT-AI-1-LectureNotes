package problems.prob21;

import customLibrary.CustomRandom;

class J_Company{
    String Name;

    public J_Company() {

    }
    void ddd(String Name) {

        double Salary = 2000;
        int MIN = 1;
        int MAX = 50;
        double RandomExample = CustomRandom.generateNumber(MIN,MAX);
        double result;
        double result2;
        result = 2000 * (1.0 + RandomExample / 100.0);
        System.out.println("이름: " + Name);
        System.out.printf("초기연봉: " + "%.2f%n", result);
        double RandomExample2 = CustomRandom.generateNumber(MIN,MAX);
        result2 = 2000 * ((1.0 + RandomExample2 / 100.0)*10);
        System.out.printf("초기연봉: " + "%.2f%n", result2);
    }
}

public class Problem21 {
    public static void main(String[] args) {
        //J사 직원들의 초봉은 2000만원입니다.
        //직원들의 연봉 인상률은 1% ~ 50% 입니다.
        //연봉 인상률은 랜덤으로 지정해주세요.
        //직원은 4명을 배치하고 이름은 적당히 지어줍니다.
        //10년 후 각자의 연봉을 출력해보도록 합시다.
        J_Company company = new J_Company();
        company.ddd("김훈");
        company.ddd("박훈");
        company.ddd("장훈");
        company.ddd("민훈");

    }
}
