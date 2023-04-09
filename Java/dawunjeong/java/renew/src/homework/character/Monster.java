package homework.character;

    public class Monster {

        final int monsterId;
        final private int MONSTER_HP = 70;
        StatusHP monsterHP;

        public Monster(int monsterId) {
            this.monsterId = monsterId;

            monsterHP = new StatusHP(MONSTER_HP);

        }

        public int getHP() {
            return MONSTER_HP;
        }

        public int getMonsterId() {
            return monsterId;
        }

        public StatusHP getStatusHP() {
            return monsterHP;
        }

        @Override
        public String toString() {
            return "Monster [monsterId=" + monsterId + ", HP=" + MONSTER_HP + "]";
        }

    }
