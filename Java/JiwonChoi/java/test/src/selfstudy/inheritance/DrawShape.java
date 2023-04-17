package selfstudy.inheritance;

/*
객체지향 - 포함
 */
public class DrawShape {
    public static void main(String[] args) {
        Point[] point1 = {   new Point(100, 100),
                        new Point(200, 200),
                        new Point(300, 300)};

        Triangle triangle1 = new Triangle(point1);
        triangle1.changeColor("Blue");
        Circle circle1 = new Circle(new Point(400, 400), 400);
        circle1.changeColor("red");

        triangle1.draw();
        circle1.draw();

    }
}

class Shape {
    String color = "black";
    void draw() {
        System.out.printf("[색 : %s]%n", color);
    }
}



class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(){
        this(0,0);
    }

    String getXY() {
        return "(" + x + "," + y + ")";
    }
}


class Circle extends Shape {
    Point centerPoint;
    int radius;

    Circle(Point centerPoint, int radius) {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }
    Circle(){
        this(new Point(0,0), 100);
    }
    void  draw() {
        System.out.printf("<<centerPoint : (%d,%d), radius : %d, color : %s>>%n", centerPoint.x, centerPoint.y, radius, color);
    }

    void changeColor (String color) {
        this.color = color;
    }

}

class Triangle extends Shape {
    Point [] p = new Point[3];

    public Triangle(Point[] p) {
        this.p = p;
    }

    void draw() {
        System.out.printf("<<[P1, P2, P3] : [%s, %s, %s], color : %s>>%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
    }
    void changeColor (String color) {
        this.color = color;
    }
}