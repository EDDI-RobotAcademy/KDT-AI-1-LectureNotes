package interfaceTest.controller;

//만들어 놓은 interface를 사용할 때 implements 인터페이스 이름
public class InterfaceTest {
    public static void main(String[] args) throws InterruptedException {

        RpgGame rpgGame = new RpgGame();
        System.out.println(rpgGame);

        rpgGame.playGame();
        System.out.println(rpgGame);
    }
}
