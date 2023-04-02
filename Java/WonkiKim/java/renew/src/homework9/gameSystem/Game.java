package homework9.gameSystem;


import homework9.component.character.Player;
import homework9.component.character.Monster;


import java.util.ArrayList;
import java.util.List;

public class Game {
    final private Player player;
    final private List<Monster> monsterList = new ArrayList<>();
    final private int NUMBER_OF_MONSTER = 2;

    public Game() {
        System.out.println("게임 시작");
        player = new Player();
        System.out.println("플레이어 생성");

        player.printStatus();
    }

    public void makeMonster() {
        System.out.println("몬스터가 " + NUMBER_OF_MONSTER + "마리 등장했다!");

        for (int i = 0; i < NUMBER_OF_MONSTER; i++) {
            monsterList.add(new Monster());
            System.out.println("몬스터 " + i + "의 체력: " + monsterList.get(i).getHp());
        }
    }

    public void battle() {
        boolean annihilation = false;
        while (!annihilation) {
            Battle.attack(player, monsterList);
            annihilation = Battle.isAnnihilation();
            if (annihilation) break;
            for (Monster monster : monsterList) {
                Battle.monsterAttack(player, monster);
                annihilation = Battle.isAnnihilation();
                if (annihilation) break;
            }
        }
    }
    public void result() {

        if (player.getStatus().getHp() <=0 ) {
            System.out.println("플레이어가 패배하였습니다.");
            System.out.println("남아있는 적");
            for (Monster monster: monsterList) {
                System.out.println("몬스터 "+monster.getMonsterId()+". 남은 체력 " +monster.getHp());
            }
        } else {
            System.out.println("플레이어가 승리하였습니다.");
            System.out.println("플레이어의 현재 스테이터스");
            player.printStatus();
        }
    }

}
