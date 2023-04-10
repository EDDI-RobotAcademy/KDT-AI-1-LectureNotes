package customLibrary.prob9;

import java.util.Random;

public class RandomMail {

    private final static Random random = new Random();
    public final static String ALPABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String ALPABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public final static String ALPABET = ALPABET_UPPER + ALPABET_LOWER;
    public final static String NUMRIC = "0123456789";
    public final static String ALPABET_NUMRIC = ALPABET + NUMRIC;


    public static String randomEmail() throws Exception {
        return randomChoice(ALPABET_NUMRIC, 10) + "@test.com";
    }



    public static String randomChoice(String strIdxs, int size) throws Exception {

        if (size < 1) {
            throw new Exception();
        }

        StringBuilder rtnStr = new StringBuilder();

        int i=0;
        while(i++ < size) {
            int random_idx = random.nextInt(strIdxs.length());
            rtnStr.append(strIdxs.substring(random_idx, random_idx+1));
        }

        return rtnStr.toString();
    }

    public static void main(String[] args) throws Exception {

        System.out.println(randomEmail());
    }


}