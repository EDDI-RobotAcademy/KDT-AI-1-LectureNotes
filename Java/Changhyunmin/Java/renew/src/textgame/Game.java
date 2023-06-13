package textgame;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Character c;
    Item[] items;
    Game(){
        c = new Character("훈",20,10,5,5,5,5);

        items = new Item[10];
        items[0] = new Item("사과",3,0,0,0,0,0);
        items[1] = new Item("블루베리",0,3,0,0,0,0);
        items[2] = new Item("힘 포션",3,0,1,0,0,0);
        items[3] = new Item("민첩 포션",0,0,0,1,0,0);
        items[4] = new Item("지능 포션",0,0,0,0,1,0);
        items[5] = new Item("능력치 포션",0,0,1,1,1,1);
        items[6] = new Item("엘릭서",3,3,3,3,3,3);
    }
    public static void main(String[] args) {
     new Game().Start();
    }

    private void Start() {
        int input = 0;
        while (true){
            System.out.println("1.내정보\t2.왼쪽 길로 간다(사냥),\t3.가운대 길로 간다(사냥),\t4.오른쪽 길로 간다(사냥)\t5.종료");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    c.showInfo();
                    break;
                case 2:
                    hunt1();
                    break;
                case 3:
                    hunt2();
                    break;

                case 4:
                    hunt3();
                    break;

                case 5:
                    System.out.println("종료되었습니다.");
                    System.exit(0);
                    break;
            }
        }
    }
    private void hunt1() {
        Monster1 m1 = new Monster1("오크",10,0,10,0,5,3,new
                Item[]{items[0],items[1],items[2],items[3],items[4],items[5],items[6]});
        System.out.println(m1.name + "을 마주쳤습니다.\n" + "전투를 시작합니다.");

        int input = 0;
        Battle : while (true){
            System.out.println("1.공격\t2.도망");
            input = sc.nextInt();

            switch (input){
                case 1:
                    c.ATTACK(m1);
                    if (m1.HP <= 0){
                        System.out.println(m1.name + "을 쓰러트렸습니다!");
                        c.getEXP(50);
                        c.getItems(m1.itemDrop());
                        break Battle;
                    }
                    m1.ATTACK(c);
                    break;

                case 2:
                    System.out.println("도망쳤습니다.");
                    break Battle;
            }
        }
    }
    private void hunt2() {
        Monster1 m1 = new Monster1("오크",10,0,10,0,5,3,new
                Item[]{items[0],items[1],items[2],items[3],items[4],items[5],items[6]});

        Monster2 m2 = new Monster2("고블린",3,0,3,0,2,1,new
            Item[]{items[0],items[1],items[2],items[3],items[4],items[5],items[6]});
        System.out.println(m1.name + "과(와)" + m2.name + "을 마주쳤습니다.\n" + "전투를 시작합니다.");

        int input = 0;
        Battle : while (true) {
            System.out.println("1." + m1.name + "공격 " + "2." + m2.name + "공격 " + "3.전체공격 " + "4.도망");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    c.ATTACK(m1);
                    if (m1.HP <= 0) {
                        System.out.println(m1.name + "을 쓰러트렸습니다!");
                        c.getEXP(50);
                        c.getItems(m1.itemDrop());
                    }
                    m1.ATTACK(c);
                    m2.ATTACK(c);
                    break;
                case 2:
                    c.ATTACK(m2);
                    if (m2.HP <= 0) {
                        System.out.println(m2.name + "을 쓰러트렸습니다!");
                        c.getEXP(10);
                        c.getItems(m2.itemDrop());
                    }
                    m1.ATTACK(c);
                    m2.ATTACK(c);
                    break;
                case 3: //한명만 죽어도 넘어가짐
                    c.SPECIAL_ATTACK(m1,m2);
                    if (m1.HP <= 0) {
                        System.out.println(m1.name + "을 쓰러트렸습니다!");
                        c.getEXP(50);
                        c.getItems(m1.itemDrop());
                        break Battle;
                    }
                    if (m2.HP <= 0) {
                        System.out.println(m2.name + "을 쓰러트렸습니다!");
                        c.getEXP(10);
                        c.getItems(m2.itemDrop());
                        break Battle;
                    }
                    m1.ATTACK(c);
                    m2.ATTACK(c);
                    break;
                case 4:
                    System.out.println("도망쳤습니다.");
                    break Battle;
            }
        }
    }
    private void hunt3() {
        Monster2 m2 = new Monster2("황금 고블린",15,0,10,0,5,3,new
                Item[]{items[0],items[1],items[2],items[3],items[4],items[5],items[6]});
        System.out.println(m2.name + "을 마주쳤습니다.\n" + "전투를 시작합니다.");

        int input = 0;
        Battle : while (true) {
            System.out.println("1.공격\t2.도망");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    c.ATTACK(m2);
                    if (m2.HP <= 0) {
                        System.out.println(m2.name + "을 쓰러트렸습니다!");
                        c.getEXP(100);
                        c.LevelUP();
                        c.getItems(m2.itemDrop());
                        break Battle;
                    }
                    m2.ATTACK(c);
                    break;
                case 2:
                    System.out.println("도망쳤습니다.");
                    break Battle;
            }
        }
    }
}