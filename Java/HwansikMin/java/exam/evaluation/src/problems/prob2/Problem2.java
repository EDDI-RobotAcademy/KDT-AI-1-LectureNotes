package problems.prob2;
//회사 클래스. 회사 이름, 매출, 직원 수, 평균연봉
public class Problem2 {
    public class COMPANY {
        private String name;
        private int salesVolume;
        private int employeeNumber;
        private int salary;

        public COMPANY() {
            this.name = "AppleKorea";
            this.salesVolume = 700000000;
            this.employeeNumber = 740;
            this.salary = 4700;
        }

        public void setInfo(String name, int salesVolume, int employeeNumber, int salary) {
            this.name = name;
            this.salesVolume = salesVolume;
            this.employeeNumber = employeeNumber;
            this.salary = salary;
        }

        public COMPANY(String name, int salesVolume, int employeeNumber, int salary) {
            this.name = name;
            this.salesVolume = salesVolume;
            this.employeeNumber = employeeNumber;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int salesVolume() {
            return salesVolume;
        }

        public int employeeNumber() {
            return employeeNumber;
        }

        public int salary() {
            return salary;
        }
    }
}
