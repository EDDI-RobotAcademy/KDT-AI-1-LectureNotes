package standardJava;

class MyMath2 {
    long a, b; // 인스턴스 변수
               // 진짜 이름은 this.a, this.b

    public MyMath2(long a, long b) {
        this.a = a;
        this.b = b;
    }

    long add() { // 인스턴스 메서드
        return a + b; // 진짜 표기법은 return this.a + this.b;
    }

    static long add(long a, long b) { // 클래스 메서드(static 메서드)
        return a + b; // 얘네는 지역변수
                      // 여기서는 인스턴스 변수, this 사용불가
    }
}

public class thisTest {
    public static void main(String[] args) {

        System.out.println(MyMath2.add(3,4)); // 클래스 메서드 호출

        MyMath2 aaa = new MyMath2(1, 2);
        aaa.add(); // 인스턴스 클래스 호출
    }
}
