package game.rpg.characterModel;

import utility.random.CustomRandom;

public class RefactorGameCharacter extends CharacterModel implements Skill {
    public RefactorGameCharacter(int statMin, int statMax, int hpMin, int hpMax) { // 캐릭터 모델에 있는 생성자를 불러오는거라고 했음

        super(CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(hpMin, hpMax));
    }

    @Override
//    public void targetingSkill(Object target) { // turnBehavior 메서드 때문에 타입 바꿔줘야함
      public <T> void targetingSkill(T target) {
        // 타겟 지정해야 하기 때문에 매개변수 Object target 넣어줌
        // monster라는 객체 생성해주고
        // 그 monster에 RefactorMonster 클래스의 정보를 이용하는 변수 target을 저장해줌
        final RefactorMonster monster = (RefactorMonster) target; // 괄호 치는 이유는 Object는 형변환이 필요하기 때문

        // 이제 스킬을 입혔을 때 데미지 설정
        // 여기서 설정하기 위해서 캐릭터 모델에서 게터를 엥간하면 다 생성해줌
        final int damage = (int) (getStrength() * 1.7f + getDexterity() * 2.5f + getAgility() * 0.6);

        // 데미지를 입었을 때 몬스터의 데미지를 계산하는 메서드 이름 미리 생성
        monster.calculateDamage(damage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
