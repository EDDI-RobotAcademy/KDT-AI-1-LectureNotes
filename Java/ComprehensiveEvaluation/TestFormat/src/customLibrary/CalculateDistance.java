package customLibrary;

public class CalculateDistance {

    private static float distance;
    public static float getDistance(int[] areaA, int[] areaB) {
        distance = (float) Math.sqrt(Math.pow((areaA[0]-areaB[0]), 2) + Math.pow((areaA[1]-areaB[1]), 2));
        return distance;
    }

}
