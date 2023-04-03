package homework.seventh;

import java.util.Scanner;

public class Character {
    Scanner scanner=new Scanner(System.in);
    String name=scanner.nextLine();
    int power=30;
    int nimbler=30;
    int intelligence=40;
    int talent=30;
    int att=power*2;
    int mp=intelligence*4;
    int hp=(power*10)+(nimbler*7);

    public Character() {
        this.name = name;
        this.power = power;
        this.nimbler = nimbler;
        this.intelligence = intelligence;
        this.talent = talent;
        this.att = att;
        this.mp = mp;
        this.hp = hp;
    }

    void showInfo(){
    System.out.println("====================");
    System.out.println("=========상태========");
    System.out.println("이름: "+name);
    System.out.println("힘: "+power);
    System.out.println("민첩: "+nimbler);
    System.out.println("지능: "+intelligence);
    System.out.println("재주: "+talent);
    System.out.println("공격력: "+att);
    System.out.println("체력: "+hp);
    System.out.println("마나: "+mp);
    }
    void attack(Monster m){
        int damage=att;
        m.hp-=damage;
        System.out.println(name+"의 공격으로 "+damage+"의 " +
                "데미지를 입은"+m.name+"의 체력이 "+m.hp+"남았습니다.");

    }
    void headShot(Monster m){
        int damage=att*2;
        m.hp-=damage;
        System.out.println(name+"의 헤드샷으로 "+damage+"의 " +
                "데미지를 입은"+m.name+"의 체력이 "+m.hp+"남았습니다.");
    }
    void doubleAttack(Monster m){
        int damage=att*9/10;
        m.hp-=damage;
        System.out.println(name+"의 더블 어택으로 "+damage+"의 " +
                "데미지를 입은"+m.name+"의 체력이 "+m.hp+"남았습니다.");

    }


}
