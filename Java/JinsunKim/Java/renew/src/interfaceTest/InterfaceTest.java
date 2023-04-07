package interfaceTest;


public class InterfaceTest {
    public static void main(String[] args) {
        GameCharacter gameCharacter = new GameCharacter();

        for(;;) {
            System.out.println("1번 스킬 데미지: "+gameCharacter.firstskill());
        }
    }

}
