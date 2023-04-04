package interfaceTest;


public class InterfaceTest {
    public static void main(String[] args) {
        GameCharacter gamecharacter = new GameCharacter();

        for (;;) {
            System.out.println("1번 스킬 데미지: " + gamecharacter.first_skill());
        }
    }

}
