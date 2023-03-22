package test;

public class Test1 {

    public static void main(String[] args) {
        final int RANDOM1 = (int)(Math.random() * 6) +1;
        System.out.println("RANDOM1 = " + RANDOM1);
        final int RANDOM2 = (int)(Math.random() * 6) +1;
        System.out.println("RANDOM2 = " + RANDOM2);
        final int RANDOM3 = (int)(Math.random() * 6) +1;
        System.out.println("RANDOM3 = " + RANDOM3);
        final int RANDOM4 = (int)(Math.random() * 6) +1;
        System.out.println("RANDOM4 = " + RANDOM4);


        final int sum = RANDOM1 + RANDOM2 + RANDOM3 + RANDOM4;
        System.out.println("sum = " + sum);

        if((sum % 4) ==0 | (sum % 3) ==0)
            System.out.println("승리하였습니다.");
        else if ((sum % 4) != 0 & (sum % 3)  !=0)
            System.out.println("패배하였습니다.");



    }
}