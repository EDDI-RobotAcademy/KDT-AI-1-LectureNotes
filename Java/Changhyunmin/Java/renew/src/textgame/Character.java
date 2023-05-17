package textgame;

public class Character {
    public String name;
    public int MAX_HP;
    public int MAX_MP;
    public int HP;
    public int MP;
    public int STR;
    public int DEX;
    public int INT;
    public int SKILL;
    public int LEVEL;
    public int EXP;
    public Item[] items;

    public Character(String name, int HP, int MP, int STR, int DEX, int INT, int SKILL) {
        this.name = name;
        this.MAX_HP = HP;
        this.MAX_MP = MP;
        this.HP = this.MAX_HP;
        this.MP = this.MAX_MP;
        this.STR = STR;
        this.DEX = DEX;
        this.INT = INT;
        this.SKILL = SKILL;
        this.LEVEL = 1;
        this.EXP = 0;
        this.items = new Item[10];
    }
    void showInfo(){
        System.out.println("이름: " + name);
        System.out.println("레벨: " + LEVEL + "(" + EXP + "/100)");
        System.out.println("체력" + HP + "/" + MAX_HP);
        System.out.println("마나" + MP + "/" + MAX_MP);
        System.out.println("완력" + STR);
        System.out.println("민첩" + DEX);
        System.out.println("지능" + INT);
        System.out.println("재주" + SKILL);
        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                System.out.println(items[i]);
            }
        }
    }
    void ATTACK(Monster1 m1){
        int Damage = STR - m1.DEF;
        Damage = Damage <= 0 ? 1 : Damage;
        m1.HP = m1.HP < Damage ? m1.HP - m1.HP : m1.HP - Damage;
        System.out.println(name + "이" + m1.name + "에게" + Damage + "만큼 데미지를 주었습니다.");
        System.out.println(m1.name + "의 HP: " + m1.HP);
    }
    void ATTACK(Monster2 m2){
        int Damage = STR - m2.DEF;
        Damage = Damage <= 0 ? 1 : Damage;
        m2.HP = m2.HP < Damage ? m2.HP - m2.HP : m2.HP - Damage;
        System.out.println(name + "이" + m2.name + "에게" + Damage + "만큼 데미지를 주었습니다.");
        System.out.println(m2.name + "의 HP: " + m2.HP);
    }
    void SPECIAL_ATTACK(Monster1 m1, Monster2 m2) {
        int Damage1 = INT * SKILL - m1.DEF;
        int Damage2 = INT * SKILL - m2.DEF;
        Damage1 = Damage1 <= 0 ? 1 : Damage1;
        Damage2 = Damage2 <= 0 ? 1 : Damage2;
        m1.HP = m1.HP < Damage1 ? m1.HP - m1.HP : m1.HP - Damage1;
        m2.HP = m2.HP < Damage2 ? m2.HP - m2.HP : m2.HP - Damage2;
        System.out.println(name + "이(가) " + m1.name + "에게 " + Damage1 + "만큼 데미지를 주었습니다.");
        System.out.println(name + "이(가) " + m2.name + "에게 " + Damage2 + "만큼 데미지를 주었습니다.");
        System.out.println(m1.name + "의 현재 HP : " + m1.HP);
        System.out.println(m2.name + "의 현재 HP : " + m2.HP);
    }
    void getEXP(int EXP){
        System.out.println(EXP + "의 경험치를 확득했습니다.");
        this.EXP = EXP;
        while (100 < this.EXP){
            LevelUP();
            this.EXP -= 100;
            //EXP 가 누적되지않음
        }
    }

    void LevelUP() {

        LEVEL++;
        MAX_HP += 10;
        MAX_MP += 5;
        STR += 1;
        DEX += 1;
        INT += 1;
        SKILL += 1;
        HP = MAX_HP;
        MP = MAX_MP;
        System.out.println("LEVEL UP!!");
    }

    void getItems(Item item) {
        System.out.println(item.name + "을 확득하였습니다.");
        for (int i = 0; i < items.length; i++){
            if (items[i] == null){
                items[i] = item;
                break;
            }
        }
        MAX_HP += item.HP;
        MAX_MP += item.MP;
        STR += item.STR;
        DEX += item.DEX;
        INT += item.INT;
        SKILL += item.SKILL;
    }
}