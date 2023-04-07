package textgame;

public class Item {
    public String name;
    public int HP;
    public int MP;
    public int STR;
    public int DEX;
    public int INT;
    public int SKILL;

    public Item(String name, int HP, int MP, int STR, int DEX, int INT, int SKILL) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
        this.STR = STR;
        this.DEX = DEX;
        this.INT = INT;
        this.SKILL = SKILL;
    }
    public String toString() {
        String info = name + " :";
        if (0 < HP) info += "채력+" + HP;
        if (0 < MP) info += "마나+" + MP;
        if (0 < STR) info += "완력" + STR;
        if (0 < DEX) info += "민첩" + DEX;
        if (0 < INT) info += "지능" + INT;
        if (0 < SKILL) info += "재주" + SKILL;
        return info;
    }

}
