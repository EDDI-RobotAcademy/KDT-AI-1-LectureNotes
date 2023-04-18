package DiceGame.Player;

import java.util.Arrays;

    public class Player {
        final private int MAX_DICE_NUM = 3; // 주사위 3개
        final private String name; // 플레이어 1, 2

        final private List<GameDice> gameDices = new ArrayList<>(); // 주사위 객체 생성
        final private GameScore gameScore;

        public Player(String name) {
            this.name = name;

            int diceNumberSum = rollDice();
            gameScore = new GameScore(diceNumberSum);
        }

        private int rollDice() {
            final int FIRST_DICE_INFO = 0; // 첫번째 주사위 정보
            final int DECISION_EVEN = 2;
            final int ODD = 1;

            int diceNumberSum = 0;

            for (int i = 0; i < MAX_DICE_NUM; i++) {
                gameDices[i] = new GameDice();

                // diceNumberSum = diceNumberSum + gameDices[i].getDiceNumber();
                diceNumberSum += gameDices[i].getDiceNumber();

                // 홀수라면 break
                // FIRST_DICE_INFO = 0  >> 배열 첫번째
                if (gameDices[FIRST_DICE_INFO].getDiceNumber() %
                        DECISION_EVEN == ODD) {
                    break;
                }
            }

            return diceNumberSum;
        }

        public GameDice getSelectedGameDice(int index) {
            return gameDices[index];
        }

        public GameScore getGameScore() {
            return gameScore;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", gameDices=" + Arrays.toString(gameDices) +
                    ", gameScore=" + gameScore +
                    '}';
        }
    }
