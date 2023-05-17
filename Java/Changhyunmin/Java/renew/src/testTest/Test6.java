package testTest;

class Triangle{
    int base;
    int height;

    public void Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    public Triangle(){
    }

    int getArea() {
        int result = (base * height) / 2;
        return result;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
public class Test6 {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.Triangle(10,17);
        System.out.println("삼각형의 넓이: " + t.getArea());
        t.setBase(50);
        t.setHeight(14);
        System.out.println(t.getArea());
    }

}
