package textgame;

public class Monster2 {
    String name;
    int MAX_HP;
    int MAX_MP;
    int HP;
    int MP;
    int STR;
    int DEF;
    Item[] items;

    public Monster2(String name, int MAX_HP, int MAX_MP, int HP, int MP, int STR, int DEF, Item[] items) {
        this.name = name;
        this.MAX_HP = HP;
        this.MAX_MP = MP;
        this.HP = this.MAX_HP;
        this.MP = this.MAX_MP;
        this.STR = STR;
        this.DEF = DEF;
        this.items = items;
    }
    void ATTACK(Character c){
        int Damage = STR - c.DEX;
        Damage = Damage <= 0 ? 1 : Damage;
        c.HP = c.HP < Damage ? c.HP - c.HP : c.HP - Damage;
        System.out.println(name + " 이(가) " + c.name + "에게 " + Damage + "만큼 데미지를 주었습니다.");
        System.out.println(c.name + "의 현재 HP : " + c.HP);
    }
    Item itemDrop(){
        return items[(int)(Math.random() * items.length)];
    }
}
