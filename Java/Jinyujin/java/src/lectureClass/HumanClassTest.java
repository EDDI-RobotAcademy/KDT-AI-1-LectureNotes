package lectureClass;

class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

public class HumanClassTest {
    public static void main(String[] args) {
        final Human human = new Human("김이름", 20);

        System.out.println("제 이름은 " + (human.getName()) + " 입니다.");
        System.out.println("제 나이는 " + (human.getAge()) + "살 입니다.");
    }
}

