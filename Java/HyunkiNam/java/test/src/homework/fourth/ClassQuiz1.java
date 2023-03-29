package homework.fourth;

class Product{
    final String name;
    final int price;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class ClassQuiz1 {
    public static void main(String[] args) {
        Product product = new Product("껌", 500);
        System.out.println(product);
    }
}
