package homework;

// 사람 나이와 이름 데이터
//
class Person {
    private Integer Age;

    public Person() {
        this.Age = Age;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        this.Age = age;
    }

}

public class Homework {
    public static void main(String[] args) {

        final Person person = new Person();

        System.out.println("나이: " + person.getAge());
        person.setAge();

    }
}
