package homework.homework6.diceGame5Ver2.game5;
public class Score {
    int beforeScore;
    int finalScore;

    public Score() {
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public void setBeforeScore(int beforeScore) {
        this.beforeScore = beforeScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "beforeScore=" + beforeScore +
                ", finalScore=" + finalScore +
                '}';
    }
}






//TODO: 보너스는 나중에 추가하자..

//    static void SumBousScore(Player player){
//    static void SumBousScore(ArrayList<Player> playerList){
//
//        int specialDice1 = 1; //변수로 넣으면 반복문 동작 안됨;;;
//        int specialDice3 = 3;
//        int specialDice4 = 4;
//
//        for (int i = 0; i<diceCount; i++) {
//            //세번째다이스 넘버가
//            switch (Player.diceArray[2].getDiceNumber()) {
//                //1이면
//                case 1:
//                    Player.setAfterScore(getDiceSum() + 3);
//
//                    break;
//
//                //3이면
//                case 3:
//                    Player.setAfterScore(getDiceSum() + 2);
//                    break;
//
//                //4면
//                case 4:
//                    Player.setAfterScore(0);
//                    break;
//                //아무것도 아니면
//                default:
//                    Player.setAfterScore(getDiceSum());
//                    break;
//            }
//        }
//
//
//
//    }
//
//}
//}
