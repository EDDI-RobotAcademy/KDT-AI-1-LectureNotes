package homework.seventh;

import utilityRandom.CustomRandom;

import java.util.Currency;
import java.util.Scanner;

public class Monster {
    Scanner scanner= new Scanner(System.in);


    String name;
    int power= CustomRandom.generateNumber(10);
    int nimbler=CustomRandom.generateNumber(10);
    int att=power*2;
    int hp=(power*10)+(nimbler*10);

    public Monster() {
        System.out.println("몬스터의 이름을 정하세요!");
        this.name = scanner.nextLine();
        this.power = power;
        this.nimbler = nimbler;
        this.att = att;
        this.hp = hp;


    }
    void showInfo(){
        System.out.println("====================");
        System.out.println("======="+name+"========");
        System.out.println("이름: "+name);
        System.out.println("힘: "+power);
        System.out.println("민첩: "+nimbler);
        System.out.println("공격력: "+att);
        System.out.println("체력: "+hp);

    }

    void attck(Character c){
        if (this.hp>0) {
            int dagmage = att;
            c.hp -= dagmage;
            System.out.println(name + "의 공격으로 " + dagmage + "의 데미지를 입어 " + c.hp + "의 체력이 남았습니다.");
        }

    }
}
