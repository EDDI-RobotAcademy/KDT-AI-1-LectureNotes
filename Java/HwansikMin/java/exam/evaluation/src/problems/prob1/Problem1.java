package problems.prob1;
//학생클래스. 학생 나이, 이름, 전공.
public class Problem1 {
    public class STUDENT {
        private int age;
        private String name;
        private String major;

        public STUDENT() {
            this.age = 30;
            this.name = "민환식";
            this.major = "화학과";
        }

        public void setInfo(int age, String name, String major) {
            this.age = age;
            this.name = name;
            this.major = major;
        }

        public STUDENT(int age, String name, String major) {
            this.age = age;
            this.name = name;
            this.major = major;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String getMajor() {
            return major;
        }
    }
}
