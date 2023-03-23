package lecturClass;
class Name{
    private String isName;
    public Name() {
        this.isName = "장현민";
        System.out.println("장현민");


    }

    public String getIsName() {
        return isName;
    }
}

class Age{
    private Integer isAge;
    public Age() {
        this.isAge = 25;
        System.out.println(25);

    }

    public Integer getIsAge() {
        return isAge;
    }
}
public class Person {
    public static void main(String[] args) {

        final Name name = new Name();
        final Age age = new Age();

        System.out.println("이름: " + name.getIsName()
                + ",나이: " + age.getIsAge());
    }
}
