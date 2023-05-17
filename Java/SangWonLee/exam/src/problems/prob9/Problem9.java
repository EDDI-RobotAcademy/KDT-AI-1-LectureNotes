package problems.prob9;

public class Problem9 {
    public static void main(String[] args) {
        final int emailNumber = 5; // 5 명
        final int emailLengthMin = 6;
        final int emailLengthMax = 8;

        for(int i = 0; i < emailNumber; i++){
            String emailSpace = "";
            int emailLength = (int) (Math.random() * (emailLengthMax - emailLengthMin + 1) + emailLengthMin);

            for (int j = 0; j < emailLength; j++){
                emailSpace += (char)(Math.random() * ('하' -'가' + 1 ) +'가');
            }
            String resultEmailSpace = emailSpace + "@test.com";

            System.out.println(resultEmailSpace);
        }



    }
}
