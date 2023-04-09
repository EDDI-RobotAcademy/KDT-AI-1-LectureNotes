package test2.arrayList.upgrade;

import java.util.ArrayList;
import java.util.List;

public class RectangleTest {
    public static void main(String[] args) {
        List<Rectangle> rectangleList =new ArrayList<>();
        rectangleList.add(new Rectangle(3,5));
        rectangleList.add(new Rectangle(4,5));
        rectangleList.add(new Rectangle(1,5));
        rectangleList.add(new Rectangle(3,10));

        for(int i =0; i< rectangleList.size(); i++) {
            System.out.println(rectangleList.get(i).getArea());
        }
    }
}
