package testTest;
class James{
    int Age;
    String Name;
    Boolean Marry;
    int Child;

    public James(int age, String name, Boolean marry, int child) {
        Age = age;
        Name = name;
        Marry = marry;
        Child = child;
    }

    @Override
    public String toString() {
        return "나이: " + Age + '\n' +
                "이름: " + Name + '\n' +
                "결혼여부: " + Marry + '\n' +
                "자녀의 수: " + Child;
    }
}
public class Test3 {
    public static void main(String[] args) {
        James james = new James(30,"James",true,3);
        System.out.println(james);

    }





}
