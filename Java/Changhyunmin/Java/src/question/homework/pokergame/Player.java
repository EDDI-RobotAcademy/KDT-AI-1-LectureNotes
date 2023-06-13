package question.homework.pokergame;

class Player implements Comparable {
    Card[] cards = new Card[5];
    int rank, money = 0;

    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        return this.rank - p.rank;
    }
}
