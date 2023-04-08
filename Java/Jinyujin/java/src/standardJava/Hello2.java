package standardJava;

class Tv{
    String Tv;
    boolean power;
    int channel;

    void power()  {power = !power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}
}

public class Hello2 {
    public static void main(String[] args) {
        Tv t; // Tv인스턴스를 참조하기 위한 변수 t 선언
        t = new Tv(); // Tv인스턴스(객체) 생성
        t.channel = 7;
        t.channelDown(); // channelDown 메소드 호출
        System.out.println("현재 채널은 " + t.channel + "입니다.");
    } // 현재 채널은 6입니다 출력
      // 코드 다 안 읽어보고 채널에 7 대입한다는 것만 보고 7이 출력될 것이라고 생각
      // 차근차근히 읽어보자
}
