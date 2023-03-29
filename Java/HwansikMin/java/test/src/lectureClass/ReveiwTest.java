package lectureClass;

class Review {
    int testNumber;

    public Review() {
        this.testNumber = testNumber;
        System.out.println("testNumber: " + testNumber);
    }

    public Review(int testNumber) {
        this.testNumber = testNumber;
        System.out.println("testNumber: " + testNumber);
    }
}

public class ReveiwTest {
    public static void main(String[] args) {
        Review review = new Review();
        Review review2 = new Review(5);
    }
}
