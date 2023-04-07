package homework.characterTest;

public class Character {
    int staminaPoint; //특정 행동을 위한 에너지 (빠른 속도, 연속 공격 등)
    int healthPoint; //체력
    int manaPoint; //마나 (마법 사용)
    final String name;

    public Character(int staminaPoint, int healthPoint, int manaPoint, String name) {
        this.staminaPoint = staminaPoint;
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
        this.name = name;
    }

    public void singleAttack(Monster monster){
        monster.staminaPoint -= 3;
        monster.healthPoint -= 3;
        monster.manaPoint -= 3;
        System.out.println(monster.name+": -3 (현재:" +monster.healthPoint+")");
    }

    public void largeAttack(Monster monster1, Monster monster2){
        monster1.staminaPoint -= 2;
        monster1.healthPoint -= 2;
        monster1.manaPoint -= 2;
        System.out.println(monster1.name+": -3 (현재:" +monster1.healthPoint+")");

        monster2.staminaPoint -= 2;
        monster2.healthPoint -= 2;
        monster2.manaPoint -= 2;
        System.out.println(monster2.name+": -3 (현재:" +monster2.healthPoint+")");
    }
}
