package interfaceTest;


//만들어 놓은 interface를 사용할 때 inplements 인터페이스 이름
public class InterfaceTest  {
    public static void main(String[] args) {
        GameCharacter gameCharacter= new GameCharacter();

        System.out.println("1번 스킬 데미지: "+gameCharacter.firstSkill());
    }


}
