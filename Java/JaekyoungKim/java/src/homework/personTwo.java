package homework;
class human{
    public int age=0;
    public String name="아무개";

    public human(final int age,final String name) {
        this.age=age;
        this.name=name;

    }
}
public class personTwo {

    public static void main(String[] args) {

        final human jae = new human(4,"김섬비");

        System.out.println("이름 : "+jae.age+"  나이 : "+jae.name);

    }
}
