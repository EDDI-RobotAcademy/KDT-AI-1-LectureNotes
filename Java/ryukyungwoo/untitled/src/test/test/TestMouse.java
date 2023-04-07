package test.test;

class Mouse {
    final private String mouseClick;
    final private String mouseBrandName;

    public Mouse(String mouseClick, String mouseBrandName) {
        this.mouseClick = mouseClick;
        this.mouseBrandName = mouseBrandName;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "mouseClick='" + mouseClick + '\'' +
                ", mouseBrandName='" + mouseBrandName + '\'' +
                '}';
    }
}


public class TestMouse {
    public static void main(String[] args) {
        Mouse mouse = new Mouse("켜짐", "익스플로러");
        System.out.println(mouse);
    }
}