package test2.arrayList.upgrade;

public class Rectangle {
    private int width;
    private int height;

    public int getArea(){
        return width * height;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
