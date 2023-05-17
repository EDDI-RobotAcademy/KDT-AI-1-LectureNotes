package problems.prob12;

public class ThreeThree {
    int randomNumber;
    int minNumber = 3;
    int maxNumber = 33;

    public int getRandomNumber() {
        return randomNumber;
    }

    public ThreeThree() {
        this.randomNumber = (int) (Math.random() *(maxNumber - minNumber + 1 ) + minNumber);

    }
}
