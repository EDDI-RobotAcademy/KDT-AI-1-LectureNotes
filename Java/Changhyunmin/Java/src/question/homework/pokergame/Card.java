package question.homework.pokergame;

class Card implements Comparable {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;
    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    int kind;
    int num;

    Card(int kind, int num) {
        this.kind = kind;
        this.num = num;
    }

    public String toString() {
        String[] kinds = {"", "♣", "♥", "◆", "♠"};
        String numbers = "0123456789XJQK";
        return  kinds[this.kind] +  numbers.charAt(this.num) ;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Card) {
            Card c1 = (Card) o;
            return this.num - c1.num;
        }
        return 1;
    }
}
