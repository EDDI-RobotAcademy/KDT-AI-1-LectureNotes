package homework.sixth.practice;

public class Score {
    private int totalAmount;

    public Score() {
    }

    public void steal(Player target) {
        // 상대 점수 뺏기
        target.getScore().changeScore(-3);

        // 내 점수 더하기
        changeScore(3);

        System.out.println("친구에게 3점 뺏기 !! ");
    }

    public void buff() {
        changeScore(2);

        System.out.println("자신에게 2점 가산 !! ");
    }

    public void death() {
        this.totalAmount = -1;
        System.out.println("무조건 패배 !!");
    }

    private int changeScore(int score) {
        this.totalAmount = this.totalAmount + score;

        return this.totalAmount;
    }

    public void add(int amount) {
        this.totalAmount += amount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

}
