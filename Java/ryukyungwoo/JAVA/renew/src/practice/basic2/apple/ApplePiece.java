package practice.basic2.apple;

import utility.random.CustomRandom;

public class ApplePiece {
    final private int applePieceNumber;
    public ApplePiece (int applePieceMinNumber, int applePieceMaxNumber) {
        this.applePieceNumber = CustomRandom.generateNumber(applePieceMinNumber, applePieceMaxNumber);
        System.out.println(applePieceNumber);
    }

    public int getApplePieceNumber() {
        return applePieceNumber;
    }

    @Override
    public String toString() {
        return "ApplePiece{" +
                "applePieceNumber=" + applePieceNumber +
                '}';
    }
}
