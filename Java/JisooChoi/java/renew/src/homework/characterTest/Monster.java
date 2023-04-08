package homework.characterTest;

public class Monster {
    int staminaPoint; //특정 행동을 위한 에너지 (빠른 속도, 연속 공격 등)
    int healthPoint; //체력
    int manaPoint; //마나 (마법 사용)
    final String name;

    public Monster(int staminaPoint, int healthPoint, int manaPoint, String name) {
        this.staminaPoint = staminaPoint;
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
        this.name = name;
    }

    public void monsterAttack(Character character){
        character.staminaPoint -= 2;
        character.healthPoint -= 2;
        character.manaPoint -= 2;
        System.out.println(character.name+": -2 (현재:" +character.healthPoint+")");
    }

    public void monsterComboAttack(Character character){
        character.staminaPoint -= 4;
        character.healthPoint -= 4;
        character.manaPoint -= 4;
        System.out.println(character.name+": -4 (현재:" +character.healthPoint+")");
    }
}
