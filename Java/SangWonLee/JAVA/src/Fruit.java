public class Fruit {

    public String name1;
    public String color1;
    public double weight1;
    public int count1;

    public Fruit(String name, String color, double weight, int count) {
        name1 = name;
        color1 = color;
        weight1 = weight;
        count1 = count;
    }


    public static void main(String[] args) {

        Fruit banana = new Fruit("banana", "yellow", 5.0, 10);
        System.out.println("name : " + banana.name1);        // name : banana
        System.out.println("color : " + banana.color1);      // color : yellow
        System.out.println("weight : " + banana.weight1);    // weight : 5.0
        System.out.println("count : " + banana.count1);
    }
}