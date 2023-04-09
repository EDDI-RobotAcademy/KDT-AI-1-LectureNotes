package practice.basic2.apple;

public class WholeAppleCost {
    private int wholeAppleCostNumber;
    final private int MAX_PIECE = 5;
    final private int MIN_PIECE = 3;
    final private int MAX_PRICE= 5000;
    final private int MIN_PRICE = 10000;
    public WholeAppleCost () {
        ApplePiece applePiece = new ApplePiece(MIN_PIECE, MAX_PIECE);
        ApplePrice applePrice = new ApplePrice(MIN_PRICE, MAX_PRICE);
        this.wholeAppleCostNumber = (applePiece.getApplePieceNumber()) * (applePrice.getApplePriceNumber());
    }

    @Override
    public String toString() {
        return "WholeAppleCost{" +
                "wholeAppleCostNumber=" + wholeAppleCostNumber +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new WholeAppleCost());
    }
}
