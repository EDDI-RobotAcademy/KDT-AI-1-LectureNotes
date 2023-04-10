package problems.prob1;

// 1번 문제 입니다.
 class Student {


        int age;
        String name;
        String major;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public static void main(String[] args) {
            Student studentAge = new Student();
            studentAge.age = 29;

            Student studentName = new Student();
            studentName.name = "고영희";

            Student studentMajor = new Student();
            studentMajor.major = "지리학";

            System.out.println(studentAge.age);
            System.out.println(studentName.name);
            System.out.println(studentMajor.major);


        }
    }

