package asdf;

public class Main {

    public static void main(String[] args) {

        Student.yass duckso = new Student.yass("덕소고등학교 1학년 1반");

//        duckso.addStudent(new Student.student("asdf", 5 ,69));
//        duckso.addStudent(new Student.student("aerwewr", 4 ,27));

        Student.student choice1 = null;
        Student.student choice2 = null;
//        Student choice = duckso.getStudents().get(0); // 이렇게 해서 맨 처음(0)에 있는 얘 result 가져올 수도 있다.

        for (Student.student st1 : duckso.getStudents()) {
            if (st1.getName().equals("asdf")) {
                choice1 = st1;
                break;
            }
        }
        for (Student.student st2 : duckso.getStudents()) {
            if (st2.getName().equals("aerwewr")) {
                choice2 = st2;
                break;
            }
        }
        System.out.println(choice1.getName() + choice1.getResult() + " " + choice1.getNumber());
        System.out.println(choice2.getName() + choice2.getResult() + " " + choice2.getNumber());

    }


}
