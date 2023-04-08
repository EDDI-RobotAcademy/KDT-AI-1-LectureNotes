package game.rpg.characterModel;

import static game.rpg.characterModel.Status.NORMAL;

public class CharacterModel {

    private int strength;    // 힘
    private int intelligent; // 지능
    private int dexterity;   // 재주
    private int agility;     // 민첩함
    private int hp;

    /////////////////////////////////
//    private int status;
//
//    // 데쓰와 노말은 죽음 판정할 때 선언된 것!
//    // 초기부터 선언해주지 않아도 괜찮음
//    public final int DEATH = -999; // 죽음 판정에 사용하기 위해 public 추가
//    final private int NORMAL = 1; // 캐릭터 모델 클래스에서 추가
    //////////////////////////////////

    // => 얘네는 Status enum에서 사용하기 때문에 이제 캐릭터모델에서는 필요 없어서 삭제
    // status만 다시 선언해준다
    private Status status; // 상태(죽었는지 살았는지)
    // 그리고 아래 status와 관련된 것들은 타입이 int로 선언되었으므로
    // Status 타입으로 변경해준다

    public CharacterModel(int strength, int intelligent, int dexterity, int agility, int hp) {
                          // int status까지 매개변수로 넣으면
                          // 리팩터몬스터랑 리팩터게임캐릭터에서 오류 발생했음 (개수차이 때문)
        this.strength = strength;
        this.intelligent = intelligent;
        this.dexterity = dexterity;
        this.agility = agility;
        this.hp = hp;

        this.status = NORMAL;
    } // 생성자 다시 만들어줌

    // 확인해야 하는 애들 게터 세터 설정
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligent() {
        return intelligent;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void calculateDamage(int damage) { // 캐릭터 모델에서 만드는게 낫다고 판단하여 옮김
        // 데미지를 입으면 당연히 hp가 깎일 것
        // hp가 데미지 입은 만큼 깎여야 한다
        hp -= damage;
    }
    // 이제 다시 playGame 메서드로 가자

    public boolean decisionDeath() { // 게임캐릭터도 몬스터도 죽을 수 있으니까 캐릭터모델에 생성
        // if hp가 0 이하라면 상태를 죽음으로 지정해라
        if (getHp() <= 0) {
            setStatus(status.DEATH);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CharacterModel{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                ", status=" + status +
                '}' + '\n';
    }


}
