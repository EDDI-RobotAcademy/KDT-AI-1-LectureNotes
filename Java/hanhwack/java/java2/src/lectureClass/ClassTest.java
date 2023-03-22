package lectureClass;

class Person {

    private Integer isAge;
    private String isName;

    public Person() {
        this.isAge = 15;
        this.isName = "Han";
        System.out.println("생성자 호춣");
    }

    public Integer getAge() {
        return isAge;
    }

    public void setAge(Integer age) {
        isAge = age;
    }

    public String getName() {
        return isName;
    }

    public void setName(String name) {
        isName = name;
    }
}

public class ClassTest {
    public static void main(String[] args) {

        final Person person = new Person();

        System.out.println("이 사람의 나이는 " + person.getAge());
        System.out.println("이 사람의 이름은 " + person.getName());
        person.setAge(30);
        person.setName("Kim");
        System.out.println("이 사람의 나이는 " + person.getAge());
        System.out.println("이 사람의 이름은 " + person.getName());

    }
}
