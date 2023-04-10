package homework.character;

public class StatusHP {
    private int currentHP;

    public StatusHP(int currentHP) {
        this.currentHP = currentHP;
    }

    // 캐릭터 스킬1 : 단일공격
    // 타겟 몬스터에게 monsterAttackSkill1_damage만큼 공격
    public int monsterAttackSkill1(StatusHP monsterHP, int monsterAttackSkill1_damage) {
        monsterHP.currentHP -= monsterAttackSkill1_damage;
        return currentHP;
    }

    // 캐릭터 스킬2 : 단일공격
    // 몬스터에게 monsterAttackSkill2_damage만큼 공격
    public int monsterAttackSkill2(StatusHP monsterHP, int monsterAttackSkill2_damage) {
        monsterHP.currentHP -= monsterAttackSkill2_damage;
        return currentHP;
    }

    // 몬스터 스킬 : 단일공격
    // 캐릭터에게 charactorAttackSkill_damage만큼 공격
    public int charactorAttackSkill(StatusHP monsterHP, int charactorAttackSkill_damage) {
        monsterHP.currentHP -= charactorAttackSkill_damage;
        return currentHP;
    }

    public int getcurrentHP() {
        return currentHP;
    }
}
