package selfstudy.inheritance;


    /*
    객체지향 - 상속
    */


class Tv {
    boolean power;
    int channel;

    void power() {
        power = !power; //'!'(not)는 boolean 값을 역전시키는 역할을 한다.
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}

class SmartTv extends Tv {
    boolean smartMode;
    void displaySmart (String text) {
        if (smartMode) {
            System.out.println(text);
        }
    }
}

class SmartTvTest {
    public static void main(String[] args) {
        SmartTv stv1 = new SmartTv();

        stv1.channel = 10;
        stv1.channelUp();
        System.out.println(stv1.channel);

        stv1.displaySmart("스마트모드입니다.");
        stv1.smartMode = true;
        stv1.displaySmart("스마트모드 입니다.");
    }
}