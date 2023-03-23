package homework;

// 사람 나이와 이름 데이터
//
class Person {
    private Integer Age;
    // private Age age; -> 표현력이 증가된다.
    // 변경하려면 객체를 새로 만들어서 사용한다.

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

public class DiceGame2 {
    public static void main(String[] args) {

        final Person person = new Person();

        //System.out.println("나이: " + person.getAge());
        //person.setAge();

    }
}
