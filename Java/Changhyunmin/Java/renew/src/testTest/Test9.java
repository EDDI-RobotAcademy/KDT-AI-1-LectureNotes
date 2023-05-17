package testTest;
class PersonConstructor{
    String Name;
    int Age;
    String Addr;
    public PersonConstructor(){
        Name = "이름 없음";
        Age = 0;
        Addr = "미상";
        System.out.println("나는 기본생상자 입니다.");
    }

    public PersonConstructor(String name) {
        this.Name = name;
        Age = 1;
        Addr = "출처불명";
        System.out.println("나는 인자생상자[1] 입니다.");
    }

    public PersonConstructor(String name, int age) {
        this(name, age, "미상");
        System.out.println("나는 인자생상자[2] 입니다.");
    }
    public PersonConstructor(String _name,int age, String addr){
        Name = _name;
        this.Age = age;
        this.Addr = addr;
    }
    void initalize(String name, int age, String addr){
        this.Name = name;
        this.Age = age;
        this.Addr = addr;
    }
    void showPersonInfo(){
        System.out.printf("%s님의 정보\n",this.Name);
        System.out.printf("나이 : %d\n",Age);
        System.out.printf("주소 : %s\n",Addr);
    }
}
public class Test9 {
    public static void main(String[] args) {
        PersonConstructor person1 = new PersonConstructor();
        System.out.println("[맴버변수 초기화용 메소드 호출전]");
        person1.showPersonInfo();
        System.out.println("[맴버변수 초기화용 메소드 호출후]");
        person1.initalize("홍길동",20,"논현동");
        person1.showPersonInfo();

        System.out.println("[이름만 전달한 값으로 초기화하기]");
        PersonConstructor person2 = new PersonConstructor("박길동");
        person2.showPersonInfo();

        System.out.println("[이름과 나이만 값으로 초기화하기]");
        PersonConstructor person3 = new PersonConstructor("최길동",40);
        person3.showPersonInfo();

        System.out.println("[모든 매개변수를 전달한 값으로 초기화하기]");
        PersonConstructor person4 = new PersonConstructor("박길동",50,"가산동");
        person4.showPersonInfo();
    }
}
