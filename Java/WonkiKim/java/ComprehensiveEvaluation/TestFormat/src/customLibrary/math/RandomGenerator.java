package customLibrary.math;

public class RandomGenerator {
    public int randomInt(int min, int max) {
        return (int) (Math.random() *( max + 1 - min)) + min;
    }
    public float randomFloat(float min, float max) {

        return (float)Math.random() * (max - min) + min;
    }
}
