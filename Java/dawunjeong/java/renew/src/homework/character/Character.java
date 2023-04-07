package homework.character;

public class Character {
    final int characterId;
    final private int POWER = 10;
    final private int SPEED = 5;
    final private int INTELLIGENCE = 5;
    final private int TALENT = 10;

    final private int CHARACTER_HP = 100;
    StatusHP characterHP;

    public Character(int characterId) {
        this.characterId = characterId;

        characterHP = new StatusHP(CHARACTER_HP);
    }

    public int getHP() {
        return CHARACTER_HP;
    }

    public int getCharacterId() {
        return characterId;
    }

    public StatusHP getcharacterHP() {
        return characterHP;
    }
}
