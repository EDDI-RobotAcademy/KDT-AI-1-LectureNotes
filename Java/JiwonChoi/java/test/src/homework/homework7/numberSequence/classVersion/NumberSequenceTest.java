package homework.homework7.numberSequence.classVersion;

public class NumberSequenceTest {
    public static void main(String[] args) {
        //1부터 100까지 출력
        NumberSequence numberSequence1 = new NumberSequence(1, 100);
        numberSequence1.BasicNumberList();

        //1부터 100까지 3의 배수만 출력
        NumberSequence numberSequence2 = new NumberSequence(1, 100);
        numberSequence2.DecisionNumberList(3);

        //1부터 100까지 4의 배수와 그 배수들을 더한 값을 출력
        NumberSequence numberSequence3 = new NumberSequence(1, 100);
        numberSequence3.DecisionNumberAndSumList(4);


    }
}
