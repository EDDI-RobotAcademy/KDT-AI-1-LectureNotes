package lectureClass;

class Person {

    private int personAge;
    private String personName;
    public Person() {
        this.personAge = 28;
        this.personName ="김재경";
    }


    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}


public class PersonHomeWork {
    public static void main(String[] args) {
        final Person jaekk =new Person();

        System.out.println("이 사람의 이름은 "+jaekk.getPersonName()+" 이 사람의 나이는 "+jaekk.getPersonAge()+" 입니다.");
        jaekk.setPersonAge(150);
        jaekk.setPersonName("몰라요");
        System.out.println("이 사람의 이름은 "+jaekk.getPersonName()+" 이 사람의 나이는 "+jaekk.getPersonAge()+" 입니다.");



    }
}
