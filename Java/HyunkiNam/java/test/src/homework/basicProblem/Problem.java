package homework.basicProblem;

class classProblem {
    final int MAX = 100;

    public classProblem() {
    }

    public void selectNumber(int number){
        switch (number){
            case 2:
                even();
                break;

            case 3:
                multipleOfThree();
                break;

            case 4:
                sumOfMultipleOfFour();
                break;
        }
    }

    private void even(){
        for (int i = 1; i <= MAX; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private void multipleOfThree(){
        for(int i=1; i<=MAX; i++){
            if(i % 3 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private void sumOfMultipleOfFour(){
        int sum = 0;
        for(int i=1; i<=MAX; i++){
            if(i % 4 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

public class Problem {
    public static void main(String[] args) {
        classProblem classProblem = new classProblem();

        classProblem.selectNumber(2);
        classProblem.selectNumber(3);
        classProblem.selectNumber(4);
    }
}