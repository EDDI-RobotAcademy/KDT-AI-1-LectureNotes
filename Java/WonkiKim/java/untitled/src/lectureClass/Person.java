package lectureClass;

public class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
        System.out.println("이름: " + this.getName() + ", 나이: " + this.getAge());
    }
    public int getAge() {
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    private void setAge(int age) {
        this.age = age;
    }
    private void setName(String name) {
        this.name = name;
    }
    public void oneYearOld() {
        this.setAge(this.getAge()+1);
        System.out.println("1년이 지나 나이가 " + this.getAge() +"살이 되었습니다.");
    }
    public void nameChange(String name){
        this.setName(name);
        System.out.println("이름을 " + this.getName()+"으로 개명하였습니다.");
    }

    public static void main(String[] args) {
        Person person = new Person("kim", 14);
        person.oneYearOld();
        person.oneYearOld();
        person.nameChange("Lee");
    }
}
