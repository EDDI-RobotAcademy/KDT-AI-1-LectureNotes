package practice1;

public class GameScore {
    int totalScore;
    int buffScore;
    int deathScore;
    int stealScore;

    public GameScore(int totalScore) { //GameScore객체(totalScore 변수 받아서) 생성자
        this.totalScore = totalScore;
    }
    public void addScore(int buffScore){ //addScore는 버프스코어 변수 받아서 총점수에 합하는 메서드
        this.totalScore = totalScore + buffScore;
    }

    public void loseScore(int deathScore) {//loseScore는 총점수가 -10000이 되는 메서드
        this.totalScore = -10000;
    }

    public void takeScore(int stealScore){ //takeScore는 stealScore 변수 받아서 뺏는 메서드
        this.totalScore = totalScore - stealScore; //가져가는거니까 마이너스 스틸점수
        otherScore = totalScore + stealScore; // 다른사람은 증가하는 거니까 플러스
    }

    public int getTotalScore(){return totalScore;} //getTotalScore는 총점수를 가져오는 메서드

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
