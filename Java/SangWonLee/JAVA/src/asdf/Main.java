package asdf;

public class Main {

    public static void main(String[] args) {

        Yass duckso = new Yass("덕소고등학교 1학년 1반");

        duckso.addStudent(new Student("asdf", 5 ,69));
        duckso.addStudent(new Student("aerwewr", 4 ,27));

//        Student choice = null;
        Student choice = duckso.getStudents().get(0);


        for (Student st : duckso.getStudents()) {
            if (st.getName().equals("asdf")) {
                choice = st;
                break;
            }
        }

        System.out.println(choice.getResult());





    }


}
