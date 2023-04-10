package homework.basic.nonclassversion;

public class PrintMultiple4 {
    public static void main(String[] args) {
        int multipleSumOf4 = 0;
        for(int i = 1; i <= 100; i++)
        {
            if(i % 4 == 0){
                multipleSumOf4 += i;
            }
        } System.out.println("1부터 100까지 숫자 중 4의 배수의 합은: " + multipleSumOf4);
    }
}
