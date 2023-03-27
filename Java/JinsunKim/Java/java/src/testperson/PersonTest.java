package testperson;

class Person {
    private String name;
    private int age;

    public Person() {

    public String getName () {
            return name;
        }
        public void setName (String name1) {
            this.name = name1;
        }
    }

    public int getAge () {
        return age;
    }
    public void setAge (int age1) {
        this.age = age1;
    }

}

public class PersonTest {
    public static void main(String[] args) {

        Person person1 = new Person();
        System.out.println(person1.getName());


    }

}


