package game.rpg.characterModel;

public interface Skill {
//    void targetingSkill(Object target); // 인터페이스를 받는 타겟팅스킬들의 타입이 변경되었으니
                                          // 해당 인터페이스도 당연히 타입 변경해주어야 함
    public <T> void targetingSkill(T target);
    // 이것을 리팩터게임캐릭터 클래스에서 잘 받기 위해서 void targetingSkill(Object target);
    // 리팩터게임캐릭터 클래스에서
    // 캐릭터모델을 상속하는 리팩터게임캐릭터 클래스에 임플먼츠까지 해준다
    // 리팩터몬스터에도 추가

    // 그리고 이건 타겟팅하는 스킬이기 때문에 매개변수 필요
    // 여기서도 매개변수 넣어야 하고
    // 이 인터페이스를 이용해서 메소드를 생성하는 다른 클래스에서도 매개변수를 다 넣어주어야 한다.
}
