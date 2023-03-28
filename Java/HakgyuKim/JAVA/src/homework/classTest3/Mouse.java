package homework.classTest3;

public class Mouse {

    final private String mouseProductName;
    private boolean click;

    public Mouse(String mouseProductName, boolean click) {
        this.mouseProductName = mouseProductName;
        this.click = false;
    }
    @Override
    public String toString() {
        return "Mouse{" +
                "mouseProductName='" + mouseProductName + '\'' +
                ", click=" + click +
                '}';
    }
}
