package homework.seventh;

public class Monster {

    String name="알락꼬리꼬마도요";
    int power=42;
    int nimbler=30;
    int att=power*2;
    int hp=(power*10)+(nimbler*10);

    public Monster() {
        this.name = name;
        this.power = power;
        this.nimbler = nimbler;
        this.att = att;
        this.hp = hp;
    }
    void showInfo(){
        System.out.println("====================");
        System.out.println("=======몬스터========");
        System.out.println("이름: "+name);
        System.out.println("힘: "+power);
        System.out.println("민첩: "+nimbler);
        System.out.println("공격력: "+att);
        System.out.println("체력: "+hp);

    }

    void attck(Character c){
        int dagmage=att;
        c.hp-=dagmage;
        System.out.println(name+"의 공격으로 "+dagmage+"의 데미지를 입어 "+c.hp+"의 체력이 남았습니다.");

    }
}
