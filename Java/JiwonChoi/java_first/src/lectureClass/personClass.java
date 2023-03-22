package lectureClass;

class Person {
    private int personOld;

    public Person(){
        this.personOld = personOld;
    }
    public int getPersonOld() {
        return personOld;
    }

    public void setPersonOld(int personOld) {
        this.personOld = personOld;
    }

    public Person(int personOld) {
        this.personOld = personOld;
    }


    private String personName;

//    public Person() {
//        this.personName = personName;     <<-- 얘를 넣으면 왜 동작이 안되는 걸까요?
//    }

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}



public class personClass {
    public static void main(String[] args) {
        final Person person1 = new Person();
        person1.setPersonName("김땡땡");
        person1.setPersonOld(20);
        System.out.println("person1의 이름은 " + person1.getPersonName() + ", 나이는 " + person1.getPersonOld() + "입니다.");

        final Person person2 = new Person();
        person2.setPersonName("이땡땡");
        person2.setPersonOld(21);
        System.out.println("person2의 이름은 " + person2.getPersonName() + ", 나이는 " + person2.getPersonOld() + "입니다.");

    }
}
