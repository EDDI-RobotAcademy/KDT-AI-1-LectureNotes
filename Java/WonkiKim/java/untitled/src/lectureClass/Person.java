package lectureClass;

public class Person {
    private int age;
    private String name;

    public Person() {
    }
    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }
    public int getAge() {
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
}
