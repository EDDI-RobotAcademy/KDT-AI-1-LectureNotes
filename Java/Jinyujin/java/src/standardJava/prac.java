package standardJava;

class MyMath {
    long add(long a, long b) {
        long result = a + b;
        return result;
    }

    public long substract(long a, long b) {
        return a - b;
    }

    public long multiply(long a, long b) {
        return a * b;
    }

    public long divide(long a, long b) {
        return a / b;
    }

    long max (long a, long b) {
        return a > b ? a : b;
    }

    long min (long a, long b) {
        return a < b ? a : b;
    }
}

public class prac {

    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long result1 = mm.add(5L, 3L);
        long result2 = mm.substract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        long result4 = mm.divide(5L, 3L);
        long result5 = mm.max(2L, 3L);
        long result6 = mm.min(5L, 3L);

        System.out.println("add(5L, 3L) = " + result1);
        System.out.println("substract(5L, 3L) = " + result2);
        System.out.println("multiply(5L, 3L) = " + result3);
        System.out.println("divide(5L, 3L) = " + result4);
        System.out.println("max(2L, 3L) = " + result5);
        System.out.println("min(5L, 3L) = " + result6);
    }
}
