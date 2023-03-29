package homework.fourth.product;

public class Product {
    //필드
    private String productName;
    private int productPrice;

    //생성자
    public Product() { }

    public Product(String productName, int productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //메서드
    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
