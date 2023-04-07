package homework.fifth.diceList.four;


    public class FourthScore {
        private int totalScore1;
        public FourthScore(int totalScore1) {
            this.totalScore1 = totalScore1;
        }
        public void takeScore(homework.third.GameScore otherScore, int stealScore){
            this.totalScore1 -= stealScore;
            otherScore.totalScore1 +=stealScore;
        }
        public void addScore(int buffScore){
            this.totalScore1+=buffScore;
        }
        public void loseAll(int deathScore){
            this.totalScore1=deathScore;
        }


        @Override
        public String toString() {
            return "GameScore{" +
                    "totalScore=" + totalScore1 +
                    '}';
        }

        public int getTotalScore() {
            return totalScore1;
        }
    }
}
