package rpgGame.characterModel;

// 극단적으로 동일한 목적 하에 동일한 기능을 하게끔 강제하는 것이 인터페이스의 역할
// 개발코드의 수정을 줄이고 유지보수성을 높임
public interface Skill {

    public <T> void targetingSkill (T target);
}
