package homework.seventh.productProblem.product;

public class Product {

    final String name;
    final String vendor;
    final int price;

    public Product(String name, String vendor, int price) {
        this.name = name;
        this.vendor = vendor;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }
}
