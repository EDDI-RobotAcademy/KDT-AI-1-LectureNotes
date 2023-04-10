package problems.prob1;

class Student {
    String Name;
    int Age;
    String Major;

    public Student(String name, int age, String major) {
        Name = name;
        Age = age;
        Major = major;
    }
    public void StudntCode(){
        System.out.println("이름: " + Name);
        System.out.println("나이: " + Age);
        System.out.println("전공: " + Major);
    }
}

